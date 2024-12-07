import { useEffect, useState } from "react";
import { AuthContext } from "../contexts/AuthContext";
import { useLocalStorage } from "../hooks/useLocalStorage";

export const AuthProvider = ({ children }) => {
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const { setItem, getItem, removeItem } = useLocalStorage();

    const getLoginByLocalStorage = () => {
        const token = getItem('token');
        if (token) {
            setIsAuthenticated(true);
            return  token ;
        }
        return null;
    };

    const [token, setToken] = useState(getLoginByLocalStorage);
    
    const verificarToken = async () => {
        
        if (token) {
            try {

                const headers = {
                    Authorization: `Bearer ${token}`,
                };
                const response = await fetch("http://localhost:8080/usuarios/verificarLogin", { method: 'GET', headers: headers });
                if (response.status === 200) return token 
                return null;
                
            } catch (error) {
                console.error("Erro ao verificar token:", error);
                return null;
            }
        }
        return null;
    };

    const logout = () => {
        removeItem('token');
        setToken(null);
        setIsAuthenticated(false);
    };

    useEffect(() => {
        if (token) {
            (async () => {
            const tokenVerificado = await verificarToken()
            if (!tokenVerificado) {
                logout()
                return
            }})()
        }
        const storedData = getLoginByLocalStorage();
        if (storedData) setToken(storedData);
    }, [isAuthenticated]);

    const login = (token) => {
        setItem('token', token);
        setToken(token);
        setIsAuthenticated(true);
    };
  
    return (
      <AuthContext.Provider value={{ isAuthenticated, login, token, verificarToken }}>
        {children}
      </AuthContext.Provider>
    );
};