import './styles.css'

export const Card = ({ infoObject, title, onClick }) => {
    const keys = Object.keys(infoObject);
    const filteredKeys = keys.filter(key => key !== 'Titulo' && key !== 'titulo' && key !== 'id');
    
    return (
        <div className="card">
            <h2>{title}</h2>
            {
            filteredKeys.length > 0 ? (
                filteredKeys.map((key, i) => (
                    <div key={i} className="card-info">
                        <h4>{key}:</h4>
                        <p>{infoObject[key]}</p>
                    </div>
                ))
            ) 
            :
            (
                <p className="no-info">Sem Informações</p>
            )}
            <button onClick={onClick}>Ver Mais</button>
        </div>
    );
};
