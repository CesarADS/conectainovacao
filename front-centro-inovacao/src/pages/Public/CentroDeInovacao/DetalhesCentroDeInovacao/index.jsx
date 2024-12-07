import { useNavigate, useParams } from "react-router-dom";
import { TopBar } from "../../../../components/TopBar";
import './styles.css'
import { useEffect, useState } from "react";
import axios from "axios";



export const DetalhesCentroDeInovacao = () => {
    const { id } = useParams();
    const [response, setResponse] = useState([])

    const location = useNavigate()
    const [loading, setLoading] = useState(false)

    
    useEffect(() => {
        setLoading(true)
        
        const fetchData = async () => {
            try {
                const response = await axios.get("http://localhost:8080/CentrosInovacao/carregar/" + Number(id))
                setResponse(response?.data)
            } finally {
                setLoading(false)
            }
        }
        fetchData()
    }, [])

    return (
        <body>
            <TopBar></TopBar>
            <main className="cards">
                <div className="card">
                    <h1>Detalhes Centro de Inovação</h1>
                    <div className="card-info">
                        <h3>Nome:</h3>
                        <p>{response?.nome}</p>
                    </div>
                    <div className="card-info">
                        <h3>Tipo:</h3>
                        <p>Centro de Inovação</p>
                    </div>
                    <div className="card-info">
                        <h3>Estado:</h3>
                        <p>{response?.estado}</p>
                    </div>
                    <div className="card-info">
                        <h3>Cidade:</h3>
                        <p>{response?.cidade}</p>
                    </div>
                    <div className="card-info">
                        <h3>Endereço:</h3>
                        <p>{response?.endereco}</p>
                    </div>
                    <div className="card-info">
                        <h3>CEP:</h3>
                        <p>{response?.cep}</p>
                    </div>
                    <div className="card-info">
                        <h3>Descrição:</h3>
                        <p>{response?.descricao}</p>
                    </div>
                    <div className="card-info">
                        <h3>Data de fundação:</h3>
                        <p>{response?.data}</p>
                    </div>
                    <div className="card-info">
                        <h3>Telefone:</h3>
                        <p>{response?.telefone}</p>
                    </div>
                    <div className="card-info">
                        <h3>Link</h3>
                        <a href={response?.link}>{response?.link}</a>
                    </div>
                    <button onClick={() => location(`/centros-de-inovacao`)}>Voltar</button>
                </div>
            </main>
        </body>
    ) 
}  