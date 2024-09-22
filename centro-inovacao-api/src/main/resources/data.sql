CREATE OR REPLACE FUNCTION atualizar_quantidade_produto()
    RETURNS TRIGGER AS $$
DECLARE
    quantidade_atual INTEGER;
BEGIN
    -- Obter a quantidade atual do produto
    SELECT quantidade INTO quantidade_atual
    FROM produtos
    WHERE id = NEW.produto_id;

    -- Verifica se é uma entrada (E)
    IF NEW.tipo_movimentacao = 'E' THEN
		IF NEW.quantidade > 0 THEN
			UPDATE produtos
			SET quantidade = quantidade_atual + NEW.quantidade
			WHERE id = NEW.produto_id;
		ELSE
			RAISE EXCEPTION 'Um produto não pode receber uma entrada igual ou menor a 0';
		END IF;

    -- Verifica se é uma saída (S) e se há estoque suficiente
    ELSIF NEW.tipo_movimentacao = 'S' THEN
        IF quantidade_atual >= NEW.quantidade THEN
            UPDATE produtos
            SET quantidade = quantidade_atual - NEW.quantidade
            WHERE id = NEW.produto_id;
        ELSE
            RAISE EXCEPTION 'Quantidade insuficiente em estoque para a saída do produto %', NEW.produto_id;
        END IF;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Criação da trigger que chama a função acima
CREATE TRIGGER trigger_atualizar_quantidade
    AFTER INSERT OR UPDATE ON movimentacoes
    FOR EACH ROW
EXECUTE FUNCTION atualizar_quantidade_produto();
