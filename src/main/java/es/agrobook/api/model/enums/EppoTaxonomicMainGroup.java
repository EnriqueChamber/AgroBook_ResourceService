package es.agrobook.api.model.enums;

public enum EppoTaxonomicMainGroup {
    A, // Animalia
    B, // Bacteria
    C, // Chromista
    F, // Fungi
    G, // Gastropoda (No aparece en Web)                            Animalia (1ANIMK) -> Mollusca (1MOLLP) -> Gastropoda (1GASTC)
    I, // Insecta (No aparece en Web)                               Animalia (1ANIMK) -> Arthropoda (1ARTHP) -> Hexapoda (1HEXAQ) -> Insecta (1INSEC)
    K, // Acari
    N, // Nematoda (No aparece en Web)                              Animalia (1ANIMK) -> Nematoda (1NEMAP)
    P, // Plantae
    R, // Rodentia (Roedores) (No aparece en Web)                   Animalia (1ANIMK) -> Chordata (1CHORP) -> Vertebrata (1VERTQ) -> Mammalia (1MAMMC) -> Rodentia (1RODEO)
    V, // Viruses and viroids
    Y, // Platyhelminthes (platelmintos) (No aparece en Web)        Animalia (1ANIMK) -> Platyhelminthes (1PLATP)
    Z  // Protozoa

    
}
