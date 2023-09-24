import {Sidebar} from "@/components/application/layout/sidebar";
import {LoadingProvider} from "@/contexts/request-loading-context";
import {SidebarProvider} from "@/contexts/sidebar-context";
import React from "react";
import Content from "./_content";
import "./globals.css";
import {QRCodeProvider} from "@/contexts/generate-qrcode-context";

export default function RootLayout({children}: { children: React.ReactNode }) {
    return (
        <LoadingProvider>
            <SidebarProvider>
                <QRCodeProvider>
                    <html lang="pt-br">
                    <body className="flex h-screen">
                    <Sidebar.Root/>
                    <Content>{children}</Content>
                    </body>
                    </html>
                </QRCodeProvider>
            </SidebarProvider>
        </LoadingProvider>
    );
}
