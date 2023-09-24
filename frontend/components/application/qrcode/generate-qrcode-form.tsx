"use client";

import {Button, buttonVariants} from "@/components/ui/button";
import {
    Dialog,
    DialogContent,
    DialogDescription,
    DialogFooter,
    DialogHeader,
    DialogTitle,
    DialogTrigger,
} from "@/components/ui/dialog";
import {routes} from "@/routes";
import React, {useState} from "react";
import {mutate} from "swr";

import {FormProvider, useForm} from "react-hook-form";
import {z} from "zod";
import {zodResolver} from "@hookform/resolvers/zod";
import {Form} from "@/components/form";
import {ApiErrorResponse, QrCode} from "@/types";
import {useMessage} from "@/hooks/useMessage";
import {MessageRoot} from "@/components/message/message-root";
import {registerLocale} from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

import pt from "date-fns/locale/pt";
import api from "@/services/api";
import {AxiosError} from "axios";
import {useQRCode} from "@/contexts/generate-qrcode-context";

registerLocale("pt", pt);

const schema = z.object({
    description: z.string()
        .nonempty("A descrição é obrigatória"),
    value: z.string()
        .nonempty("O valor é obrigatório")
});

export default function GenerateQrcodeForm() {
    const [open, setOpen] = useState(false);
    const {message, showMessage, hideMessage} = useMessage();
    const {setImgSrc} = useQRCode()

    const createQrCodeForm = useForm<QrCode>({
        resolver: zodResolver(schema),
    });

    const {handleSubmit, reset} = createQrCodeForm;

    async function generateQrcode(qrcode: QrCode) {
        await api.post(routes.qrcode.root, qrcode, {responseType: "blob"})
            .then((response) => {
                const blob = new Blob([response.data], {type: 'image/png'});
                const objectURL = URL.createObjectURL(blob);
                setImgSrc(objectURL);
                reset({
                    description: "",
                    value: "",
                    durationInMinutes: 0
                });
                hideMessage();
                setOpen(false);
            }).catch((error: AxiosError<ApiErrorResponse>) => {
                showMessage(error.response!.data.detail);
            });
    }

    return (
        <>
            <Dialog open={open} onOpenChange={setOpen}>
                <DialogTrigger onClick={() => setOpen(true)} className={buttonVariants({variant: "default"})}>
                    Gerar novo QRCode
                </DialogTrigger>
                <DialogContent className="max-w-[425px] border border-gray-300 bg-white">

                    <DialogHeader>
                        <DialogTitle>Validação de Frequência</DialogTitle>
                        <DialogDescription>
                            Com este QRCode você poderá validar sua presença
                        </DialogDescription>
                    </DialogHeader>

                    <MessageRoot value={message}/>

                    <FormProvider {...createQrCodeForm}>
                        <form onSubmit={handleSubmit(generateQrcode)} className="grid gap-4">
                            <Form.Field>
                                <Form.Label htmlFor="description">
                                    Descrição
                                </Form.Label>
                                <Form.TextField name="description"/>
                                <Form.ErrorMessage field="description"/>
                            </Form.Field>
                            <Form.Field>
                                <Form.Label htmlFor="value">
                                    Valor
                                </Form.Label>
                                <Form.TextField name="value"/>
                                <Form.ErrorMessage field="value"/>
                            </Form.Field>
                            <DialogFooter>
                                <Button type="submit">
                                    Gerar
                                </Button>
                            </DialogFooter>
                        </form>
                    </FormProvider>
                </DialogContent>
            </Dialog>
        </>
    );
}


