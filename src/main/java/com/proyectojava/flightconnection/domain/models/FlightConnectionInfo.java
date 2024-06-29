package com.proyectojava.flightconnection.domain.models;

    public class FlightConnectionInfo {
        private int id_trayectoria;
        private String trayectoria_numero;
        private String lugar_ida;
        private String lugar_llegada;
    
        
        public FlightConnectionInfo(int id_trayectoria, String trayectoria_numero, String lugar_ida, String lugar_llegada) {
            this.id_trayectoria = id_trayectoria;
            this.trayectoria_numero = trayectoria_numero;
            this.lugar_ida = lugar_ida;
            this.lugar_llegada = lugar_llegada;
        }
    
        // Getters and Setters
    
        public int getId_trayectoria() {
            return id_trayectoria;
        }
    
        public void setId_trayectoria(int id_trayectoria) {
            this.id_trayectoria = id_trayectoria;
        }
    
        public String getTrayectoria_numero() {
            return trayectoria_numero;
        }
    
        public void setTrayectoria_numero(String trayectoria_numero) {
            this.trayectoria_numero = trayectoria_numero;
        }
    
        public String getLugar_ida() {
            return lugar_ida;
        }
    
        public void setLugar_ida(String lugar_ida) {
            this.lugar_ida = lugar_ida;
        }
    
        public String getLugar_llegada() {
            return lugar_llegada;
        }
    
        public void setLugar_llegada(String lugar_llegada) {
            this.lugar_llegada = lugar_llegada;
        }
}

