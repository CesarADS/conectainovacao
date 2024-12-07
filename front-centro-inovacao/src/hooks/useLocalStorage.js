import { useCallback } from "react";


export const useLocalStorage = () => {
    const setItem = useCallback((key, value) => {
        localStorage.setItem(key, value);
    }, []);

    const getItem = useCallback((key) => {
        return localStorage.getItem(key);
    }, []);

    const removeItem = useCallback((key) => {
        localStorage.removeItem(key);
    }, []);

    return {
        setItem,
        getItem,
        removeItem
    };
};