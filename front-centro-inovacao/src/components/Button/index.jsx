import { useLocation, useNavigate } from "react-router-dom"
import './styles.css'

export const Button = ({ text, to }) => {
    const navigate = useNavigate()    
    const location = useLocation()
    const classname = location.pathname === '/' ? 'botao' : 'botao-admin'
    return (
        <button onClick={() => navigate(to)} className={classname}>{text}</button>
    )

}