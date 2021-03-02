package com.priscilla.web.entities.skiresorts;

public class MountainStat {
    private Integer acres;
    private Integer peakElevation;
    private Integer baseElevation;
    private Integer numRuns;
    private Integer numLifts;
    private Integer numTerrainParks;
    private Integer pctBeginnerTerrain;
    private Integer pctIntermediateTerrain;
    private Integer pctAdvancedTerrain;
    private Integer pctExpertTerrain;

    private boolean nightSkiing;
    private boolean freeKidsSkiing;

    public Integer getAcres() {
        return acres;
    }

    public void setAcres(Integer acres) {
        this.acres = acres;
    }

    public Integer getPeakElevation() {
        return peakElevation;
    }

    public void setPeakElevation(Integer peakElevation) {
        this.peakElevation = peakElevation;
    }

    public Integer getBaseElevation() {
        return baseElevation;
    }

    public void setBaseElevation(Integer baseElevation) {
        this.baseElevation = baseElevation;
    }

    public Integer getNumRuns() {
        return numRuns;
    }

    public void setNumRuns(Integer numRuns) {
        this.numRuns = numRuns;
    }

    public Integer getNumLifts() {
        return numLifts;
    }

    public void setNumLifts(Integer numLifts) {
        this.numLifts = numLifts;
    }

    public Integer getNumTerrainParks() {
        return numTerrainParks;
    }

    public void setNumTerrainParks(Integer numTerrainParks) {
        this.numTerrainParks = numTerrainParks;
    }

    public Integer getPctBeginnerTerrain() {
        return pctBeginnerTerrain;
    }

    public void setPctBeginnerTerrain(Integer pctBeginnerTerrain) {
        this.pctBeginnerTerrain = pctBeginnerTerrain;
    }

    public Integer getPctIntermediateTerrain() {
        return pctIntermediateTerrain;
    }

    public void setPctIntermediateTerrain(Integer pctIntermediateTerrain) {
        this.pctIntermediateTerrain = pctIntermediateTerrain;
    }

    public Integer getPctAdvancedTerrain() {
        return pctAdvancedTerrain;
    }

    public void setPctAdvancedTerrain(Integer pctAdvancedTerrain) {
        this.pctAdvancedTerrain = pctAdvancedTerrain;
    }

    public Integer getPctExpertTerrain() {
        return pctExpertTerrain;
    }

    public void setPctExpertTerrain(Integer pctExpertTerrain) {
        this.pctExpertTerrain = pctExpertTerrain;
    }

    public boolean isNightSkiing() {
        return nightSkiing;
    }

    public void setNightSkiing(boolean nightSkiing) {
        this.nightSkiing = nightSkiing;
    }

    public boolean isFreeKidsSkiing() {
        return freeKidsSkiing;
    }

    public void setFreeKidsSkiing(boolean freeKidsSkiing) {
        this.freeKidsSkiing = freeKidsSkiing;
    }
}
