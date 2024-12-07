import { useEffect, useState } from "react"
import { Card } from "../../../components/Card"
import { TopBar } from "../../../components/TopBar"
import './style.css'
import { useNavigate } from "react-router-dom"
import axios from "axios"



export const ParquesCientificos = () => {
    const [ response, setResponse ] = useState([])
    const [ data, setData ] = useState([])
    const [ loading, setLoading ] = useState(false)

    const location = useNavigate()
    
    useEffect(() => {
        setLoading(true)
        
        const fetchData = async () => {
            try {
                const response = await axios.get("http://localhost:8080/ParquesCientificos/carregar")
                setResponse(response.data)
            } finally {
                setLoading(false)
            }
        }
        fetchData()
    }, [])

    useEffect(() => {
        setData(response.map((object) => {
            return {
                id: object?.id,
                Titulo: object?.nome,
                Descrição: object?.descricao,
                Estado: object?.estado,
                Cidade: object?.cidade
            }
        }))
    }, [response])
    
    return (
        <body>
            <TopBar></TopBar>
            <main>
                <h1> Parques Científicos </h1>
                {
                    loading ? <p>Carregando...</p> 
                    :
                    (
                        <div className="cards">
                            {
                                data.length > 0 ? (
                                    data.map((object, i) => (
                                        <Card 
                                        key={i} 
                                        infoObject={object} 
                                        title={object.Titulo} 
                                        onClick={() =>  location(`/detalhes-parque-cientifico/${object.id}`)}>
                                        </Card>
                                    ))
                                    
                                )
                                :
                                (
                                    <p>Sem Informações</p>
                                )
                            }
                        </div>
                    )
                }
            </main>
        </body>
    )
}