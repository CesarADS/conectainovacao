import { useLocation, useNavigate } from 'react-router-dom'
import { ButtonTopBar } from '../ButtonTopBar'
import './styles.css'
import axios from 'axios'
import { useAuth } from '../../hooks/useAuth'

export const TopBar = () => {
    const navigate = useNavigate()
    const location = useLocation()
    
    const auth = useAuth()
    
    const isHome = location.pathname === '/' ? true : false
    const isAdmin = location.pathname.includes('-admin') ? true : false

    const showAlertWithInput = async () => {

        const userInput = prompt("Digite a senha do administrador:");
        
        try {
            const response = await axios.post("http://localhost:8080/usuarios/login", 
                {
                    login: 'admin', 
                    senha: userInput
                }, 
                {
                    'Content-Type': 'application/json'
                })

            if (response.status == 200) {
                auth.login(response.data.token)
                return navigate('/admin')
            }
        } catch (error) {
            if (error.response) {
                alert("Senha root incorreta!")
        } else {
            alert("Algo deu errado!")
        }

    }
    }

    const handleClick = () => {
        if(isHome)  return showAlertWithInput()
        if(isAdmin) return navigate(-1)
        return navigate('/')
    }


    return (
        <header>
            <div className='top-div'>
            <ButtonTopBar onClick={() => handleClick()} >
                { isHome ? 'Área do adiministrador' : <img src="/home.png" className='home-icon'/>}
            </ButtonTopBar>
            </div>
            <div className="logo top-div">
                <img src="/bandeira.png" alt="Bandeira de Santa Catarina" className="bandeira"/>
                <h1>Conecta Inovação</h1>
            </div>
            <div className='top-div'>

            </div>
        </header>
    )
}