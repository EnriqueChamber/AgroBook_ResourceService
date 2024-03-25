package es.agrobook.api.model.enums;

public enum EspecieEppoReino {
    Z, // Protozoa
    Y, // Platyhelminthes (platelmintos) (No aparece en Web)        Animalia (1ANIMK) -> Platyhelminthes (1PLATP)
    V, // Viruses and viroids
    R, // Rodentia (Roedores) (No aparece en Web)                   Animalia (1ANIMK) -> Chordata (1CHORP) -> Vertebrata (1VERTQ) -> Mammalia (1MAMMC) -> Rodentia (1RODEO)
    P, // Plantae
    N, // Nematoda (No aparece en Web)                              Animalia (1ANIMK) -> Nematoda (1NEMAP)
    K, // Archaea
    I, // Insecta (No aparece en Web)                               Animalia (1ANIMK) -> Arthropoda (1ARTHP) -> Hexapoda (1HEXAQ) -> Insecta (1INSEC)
    G, // Gastropoda (No aparece en Web)                            Animalia (1ANIMK) -> Mollusca (1MOLLP) -> Gastropoda (1GASTC)
    F, // Fungi
    C, // Chromista
    B, // Bacteria
    A // Animalia
    
}
