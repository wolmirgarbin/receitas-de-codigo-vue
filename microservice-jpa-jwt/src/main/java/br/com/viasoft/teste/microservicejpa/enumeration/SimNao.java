/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.viasoft.teste.microservicejpa.enumeration;

import lombok.Getter;


public enum SimNao {
    
    S("Sim"), N("Não");
    
    @Getter
    private String label;
    
    private SimNao(final String label) {
        this.label = label;
    }
    
}