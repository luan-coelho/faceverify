"use client";

import "./index.css";

import {useSidebar} from "@/contexts/sidebar-context";
import {QrCodeIcon} from "lucide-react";
import SidebarMenu from "./sidebar-menu";
import SidebarMenuItem from "./sidebar-menu-item";
import LogoUnitins from "@/public/images/unitins.png"
import Image from "next/image";

export default function SidebarRoot() {
    const {isOpen} = useSidebar();

    return (
        <aside className={`${isOpen ? "sidebar-open" : "sidebar-close"}`}>
            <div className={`flex items-center flex-col justify-center gap-3 ${isOpen ? "px-4" : ""}`}>
                <div className="text-black rounded-full p-1">
                    <Image src={LogoUnitins} width={150} height={150} alt="Logo Unitins"/>
                </div>
                {isOpen && <div className="text-sm font-medium leading-7 hidden md:block">
                    Trabalho de Coclusão de Curso I
                </div>}
            </div>

            <SidebarMenu>
                <SidebarMenuItem description="Gerar QRCode" pathName="/qrcode">
                    <QrCodeIcon/>
                </SidebarMenuItem>
            </SidebarMenu>
        </aside>
    );
}
