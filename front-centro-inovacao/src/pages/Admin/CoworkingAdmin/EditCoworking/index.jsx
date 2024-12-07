import { useEffect, useState } from "react";
import { TopBar } from "../../../../components/TopBar";
import "./styles.css";
import { useAuth } from "../../../../hooks/useAuth";
import { useNavigate, useParams } from "react-router-dom";
import axios from "axios";

export const EditCoworkingAdmin = () => {
    const { id } = useParams();
    const { token } = useAuth();
    const [nome, setNome] = useState("");
    const [estado, setEstado] = useState("");
    const [dataFundacao, setDataFundacao] = useState("");
    const [cidade, setCidade] = useState("");
    const [endereco, setEndereco] = useState("");
    const [descricao, setDescricao] = useState("");
    const [link, setLink] = useState("");
    const [telefone, setTelefone] = useState("");
    const [cep, setCep] = useState("");
    const [horario_funcionamento, setHorario_funcionamento] = useState("");

    const [response, setResponse] = useState();

    const navigate = useNavigate();

    const fetchData = async () => {
        try {
            const response = await axios.get("http://localhost:8080/Coworkings/carregar/" + Number(id));
            setResponse(response?.data);
        } catch (error) {
            console.error("Algo deu errado!");
        }
    };

    useEffect(() => {
        fetchData();
    }, [id]);

    useEffect(() => {
        if (response) {
            setNome(response?.nome);
            setEstado(response?.estado);
            
            // Certifique-se de formatar a data para o formato yyyy-mm-dd
            const formattedDate = response?.data ? formatDateToYYYYMMDD(response?.data) : "";
            setDataFundacao(formattedDate); // Agora 'data' será no formato correto
            
            setHorario_funcionamento(response?.horario_funcionamento);
            setCep(response?.cep);
            setCidade(response?.cidade);
            setEndereco(response?.endereco);
            setDescricao(response?.descricao);
            setLink(response?.link);
            setTelefone(response?.telefone);
        }
    }, [response]);
    
    // Função para garantir que a data esteja no formato yyyy-mm-dd
    const formatDateToYYYYMMDD = (date) => {
        if (!date) return "";
        const [year, month, day] = date.split("-"); // Supondo que a data seja no formato yyyy-mm-dd
        return `${year}-${month}-${day}`; // Retorna no formato correto para input[type="date"]
    };

    // Atualiza a data no formato dd/mm/yyyy
    const handleDateChange = (e) => {
        const value = e.target.value; // Valor no formato yyyy-mm-dd
        setDataFundacao(value); // Atualiza a data com o valor formatado corretamente
    };

    const onConfirm = async () => {
        try {
            await axios.put(
                "http://localhost:8080/Coworkings/atualizar/" + id,
                {
                    cidade: cidade,
                    estado: estado,
                    nome: nome,
                    endereco: endereco,
                    cep: cep,
                    data: formatDateToYYYYMMDD(dataFundacao), // Passa a data no formato yyyy-mm-dd para o servidor
                    descricao: descricao,
                    link: link,
                    telefone: telefone,
                    horario_funcionamento: horario_funcionamento
                },
                { headers: { Authorization: `Bearer ${token}` } }
            );
            alert("Agente editado com sucesso!")
        } catch (error) {
            alert("Algo deu errado!")
        } finally {
            navigate(-1)
        }
    };

    return (
        <div>
            <TopBar />
            <main className="admin-edit-container">
                <div className="admin-edit-card">
                    <div className="card-content-inputs">
                    <h1>Editar Coworking</h1>
                    </div>
                    <div className="card-content-inputs">
                        <label htmlFor="nome">Nome</label>
                        <input
                            id="nome"
                            type="text"
                            value={nome}
                            onChange={(e) => setNome(e.target.value)}
                            placeholder="Nome do Coworking"
                        />
                    </div>
                    <div className="card-content-inputs">
                        <label htmlFor="cidade">Cidade</label>
                        <input
                            id="cidade"
                            type="text"
                            value={cidade}
                            onChange={(e) => setCidade(e.target.value)}
                            placeholder="Cidade do Coworking"
                        />
                    </div>
                    <div className="card-content-inputs">
                        <label htmlFor="endereco">Endereço</label>
                        <input
                            id="endereco"
                            type="text"
                            value={endereco}
                            onChange={(e) => setEndereco(e.target.value)}
                            placeholder="Endereço do Coworking"
                        />
                    </div>
                    <div className="card-content-inputs">
                        <label htmlFor="descricao">Descrição</label>
                        <input
                            id="descricao"
                            type="text"
                            value={descricao}
                            onChange={(e) => setDescricao(e.target.value)}
                            placeholder="Descrição do Coworking"
                        />
                    </div>
                    <div className="card-content-inputs">
                        <label htmlFor="estado">Estado</label>
                        <input
                            id="estado"
                            type="text"
                            value={estado}
                            onChange={(e) => setEstado(e.target.value)}
                            placeholder="Estado do Coworking"
                        />
                    </div>
                    <div className="card-content-inputs">
                        <label htmlFor="cep">CEP</label>
                        <input
                            id="cep"
                            type="number"
                            value={cep}
                            onChange={(e) => setCep(e.target.value)}
                            placeholder="CEP do Coworking"
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
                            placeholder="Telefone do Coworking"
                        />
                    </div>
                    <div className="card-content-inputs">
                        <label htmlFor="link">Site</label>
                        <input
                            id="link"
                            type="text"
                            value={link}
                            onChange={(e) => setLink(e.target.value)}
                            placeholder="Site do Coworking"
                        />
                    </div>
                    <div className="card-content-inputs">
                        <label htmlFor="horario_funcionamento">Horário de funcionamento</label>
                        <input
                            id="horario_funcionamento"
                            type="text"
                            value={horario_funcionamento}
                            onChange={(e) => setHorario_funcionamento(e.target.value)}
                            placeholder="Horário de funcionamento do Coworking"
                        />
                    </div>
                    <button className="admin-edit-button" onClick={onConfirm}>
                        Salvar
                    </button>
                </div>
            </main>
        </div>
    );
};
