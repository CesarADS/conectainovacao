import { useState } from "react";
import { TopBar } from "../../../../components/TopBar";
import "./styles.css";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../../../../hooks/useAuth";
import axios from "axios";

export const AdicionarCentroDeInovacaoAdmin = () => {

    const { token } = useAuth();
    const navigate = useNavigate("");
    const [nome, setNome] = useState("");
    const [estado, setEstado] = useState("");
    const [dataFundacao, setDataFundacao] = useState("");
    const [cidade, setCidade] = useState("");
    const [endereco, setEndereco] = useState("");
    const [descricao, setDescricao] = useState("");
    const [link, setLink] = useState("");
    const [telefone, setTelefone] = useState("");
    const [cep, setCep] = useState("");

    // Formata a data para dd/mm/yyyy
    const formatDateToDDMMYYYY = (date) => {
        if (!date) return "";
        const [year, month, day] = date.split("-");
        return `${day}/${month}/${year}`;
    };

    // Formata a data para yyyy-mm-dd
    const formatDateToYYYYMMDD = (date) => {
        if (!date) return "";
        const [day, month, year] = date.split("/");
        return `${year}-${month}-${day}`;
    };

    // Atualiza a data no formato dd/mm/yyyy
    const handleDateChange = (e) => {
        const value = e.target.value; // Valor no formato yyyy-mm-dd
        const formattedDate = formatDateToDDMMYYYY(value); // Converte para dd/mm/yyyy
        setDataFundacao(formattedDate); // Atualiza o estado
    };

    const onConfirm = async () => {
        
        try{
            const fetchData = await axios.post("http://localhost:8080/CentrosInovacao/criar", {
                cidade: cidade,
                estado: estado,
                nome: nome,
                endereco: endereco,
                cep: cep,
                data: formatDateToYYYYMMDD(dataFundacao),
                descricao: descricao,
                link: link,
                telefone: telefone
            }, 
            {headers: {Authorization: `Bearer ${token}`}})
            navigate(-1)
            alert("Agente adicionado!")
        } catch (error) {
            alert("Algo deu errado!")
        }
    };

    return (
        <div>
            <TopBar />
            <main className="admin-edit-container">
                <div className="admin-edit-card">
                    <div className="card-content-inputs">
                        <h1>Adicionar Centro de Inovação</h1>
                    </div>
                    <div className="card-content-inputs">
                        <label htmlFor="nome">Nome</label>
                        <input
                            id="nome"
                            type="text"
                            value={nome}
                            onChange={(e) => setNome(e.target.value)}
                            placeholder="Nome do Centro de Inovação"
                        />
                    </div>
                    <div className="card-content-inputs">
                        <label htmlFor="cidade">Cidade</label>
                        <input
                            id="cidade"
                            type="text"
                            value={cidade}
                            onChange={(e) => setCidade(e.target.value)}
                            placeholder="Cidade do Centro de Inovação"
                        />
                    </div>
                    <div className="card-content-inputs">
                        <label htmlFor="endereco">Endereço</label>
                        <input
                            id="endereco"
                            type="text"
                            value={endereco}
                            onChange={(e) => setEndereco(e.target.value)}
                            placeholder="Endereço do Centro de Inovação"
                        />
                    </div>
                    <div className="card-content-inputs">
                        <label htmlFor="descricao">Descrição</label>
                        <input
                            id="descricao"
                            type="text"
                            value={descricao}
                            onChange={(e) => setDescricao(e.target.value)}
                            placeholder="Descrição do Centro de Inovação"
                        />
                    </div>
                    <div className="card-content-inputs">
                        <label htmlFor="estado">Estado</label>
                        <input
                            id="estado"
                            type="text"
                            value={estado}
                            onChange={(e) => setEstado(e.target.value)}
                            placeholder="Estado do Centro de Inovação"
                        />
                    </div>
                    <div className="card-content-inputs">
                        <label htmlFor="cep">CEP</label>
                        <input
                            id="cep"
                            type="number"
                            value={cep}
                            onChange={(e) => setCep(e.target.value)}
                            placeholder="CEP do Centro de Inovação"
                        />
                    </div>
                    <div className="card-content-inputs">
                        <label htmlFor="dataFundacao">Data de Fundação</label>
                        <input
                            id="dataFundacao"
                            type="date"
                            value={formatDateToYYYYMMDD(dataFundacao)} // Formato compatível com o tipo date
                            onChange={handleDateChange} // Atualiza no formato dd/mm/yyyy
                        />
                    </div>
                    <div className="card-content-inputs">
                        <label htmlFor="telefone">Telefone</label>
                        <input
                            id="telefone"
                            type="number"
                            value={telefone}
                            onChange={(e) => setTelefone(e.target.value)}
                            placeholder="Telefone do Centro de Inovação"
                        />
                    </div>
                    <div className="card-content-inputs">
                        <label htmlFor="link">Site</label>
                        <input
                            id="link"
                            type="text"
                            value={link}
                            onChange={(e) => setLink(e.target.value)}
                            placeholder="Site do Centro de Inovação"
                        />
                    </div>
                    <button className="admin-edit-button" onClick={onConfirm}>
                        Adicionar
                    </button>
                </div>
            </main>
        </div>
    );
};
