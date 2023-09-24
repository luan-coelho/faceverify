"use client";

import React, {createContext, ReactNode, useContext, useState} from "react";

interface GenerateQRCodeContextProps {
    imgSrc: string;
    setImgSrc: React.Dispatch<React.SetStateAction<string>>;
}

const GenerateQRCodeContext = createContext<GenerateQRCodeContextProps | undefined>(undefined);

export const useQRCode = () => {
    const context = useContext(GenerateQRCodeContext);
    if (!context) {
        throw new Error("useQRCode deve ser usado dentro de um LoadingProvider");
    }
    return context;
};

interface QRCodeProviderProps {
    children: ReactNode;
}

export const QRCodeProvider: React.FC<QRCodeProviderProps> = ({ children }) => {
    const [imgSrc, setImgSrc] = useState<string>(null);
    return <GenerateQRCodeContext.Provider value={{ imgSrc, setImgSrc }}>{children}</GenerateQRCodeContext.Provider>;
};

