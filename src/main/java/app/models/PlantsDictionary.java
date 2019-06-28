package app.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "plants_dictionary")
public class PlantsDictionary {

    private String category;
    private String commonName;
    private String diseasesPests;
    private String exposure;
    private String family;
    private String flowering;
    private String flowersColor;
    private String foliageType;
    private String height;
    @Id
    private String latinName;
    private String multiplicationMethods;
    private String origin;
    private String plantType;
    private String plantationRepotting;
    private String relatedSpecies;
    private String rusticity;
    private String soilAcidity;
    private String soilHumidity;
    private String soilType;
    private String synonyms;
    private String trimming;
    private String toxicity;
    private String plantUsage;
    private String vegetationType;

    public PlantsDictionary() {
    }

    public PlantsDictionary(String category, String commonName, String diseasesPests, String exposure, String family, String flowering, String flowersColor, String foliageType, String height, String latinName, String multiplicationMethods, String origin, String plantType, String plantationRepotting, String relatedSpecies, String rusticity, String soilAcidity, String soilHumidity, String soilType, String synonyms, String trimming, String toxicity, String plantUsage, String vegetationType) {
        this.category = category;
        this.commonName = commonName;
        this.diseasesPests = diseasesPests;
        this.exposure = exposure;
        this.family = family;
        this.flowering = flowering;
        this.flowersColor = flowersColor;
        this.foliageType = foliageType;
        this.height = height;
        this.latinName = latinName;
        this.multiplicationMethods = multiplicationMethods;
        this.origin = origin;
        this.plantType = plantType;
        this.plantationRepotting = plantationRepotting;
        this.relatedSpecies = relatedSpecies;
        this.rusticity = rusticity;
        this.soilAcidity = soilAcidity;
        this.soilHumidity = soilHumidity;
        this.soilType = soilType;
        this.synonyms = synonyms;
        this.trimming = trimming;
        this.toxicity = toxicity;
        this.plantUsage = plantUsage;
        this.vegetationType = vegetationType;
    }
}
