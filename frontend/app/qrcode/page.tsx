"use client"

import Title from "@/components/commons/title";
import {Card, CardContent, CardHeader} from "@/components/ui/card";
import React from "react";
import GenerateQrcodeForm from "@/components/application/qrcode/generate-qrcode-form";
import {NoData} from "@/components/commons/no-data";
import {useQRCode} from "@/contexts/generate-qrcode-context";

export default function Qrcode() {
    const {imgSrc} = useQRCode()

    return <>
        <Title>Generate QRCode</Title>
        <Card>
            <CardHeader>
                <GenerateQrcodeForm/>
            </CardHeader>
            <CardContent>
                {imgSrc ?
                    <div className="flex items-center justify-center">
                        <img src={imgSrc} alt="Generated QR Code" className="w-4/12"/>
                    </div> :
                    <NoData>Nenhum QRCode foi gerado</NoData>
                }
            </CardContent>
        </Card>
    </>
}
