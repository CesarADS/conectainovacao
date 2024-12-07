import './styles.css'


export const ButtonTopBar = ({onClick, children}) => {
    return <button onClick={onClick} className="admin-button">{children}</button>
}



