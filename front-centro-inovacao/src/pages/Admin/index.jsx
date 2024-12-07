import { Button } from "../../components/Button"
import { TopBar } from "../../components/TopBar"
import './styles.css'


export const AdminHome = () => {
    return (
        <body className="admin-body">
        <TopBar></TopBar>
        <div className="container-admin">
            <div className="content-admin">
                <h2>Escolha o tipo de agente de inovação para gerenciar</h2>
                <div className="options-admin">
                    <Button text="Centros de Inovação" to="/centros-de-inovacao-admin"></Button>
                    <Button text="Parques Científicos" to="/parques-cientificos-admin"></Button>
                    <Button text="Coworkings"          to="/coworkings-admin"></Button>
                </div>
            </div>
        </div>
    </body>
    )
}   