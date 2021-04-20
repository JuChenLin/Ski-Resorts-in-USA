package com.priscilla.web.entity.skiresort;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "mountain_stat")
@SQLDelete(sql = "UPDATE mountain_stat SET deleted = true WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted <> true")
public class MountainStat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(6) ZEROFILL", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "deleted", nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted = false;

    @Column
    private Integer acres;
    @Column
    private Integer baseElevation;
    @Column
    private Integer peakElevation;
    @Column
    private Integer numRuns;
    @Column
    private Integer numLifts;
    @Column
    private Integer numTerrainParks;
    @Column
    private Integer pctBeginnerTerrain;
    @Column
    private Integer pctIntermediateTerrain;
    @Column
    private Integer pctAdvancedTerrain;
    @Column
    private Integer pctExpertTerrain;

    @OneToOne
    @JoinColumn(name = "ski_resort_id", updatable = false)
    @JsonIgnore
    private SkiResort skiResort;

//    @OneToOne(fetch = FetchType.LAZY)
//    @MapsId
//    private SkiResort skiResort;

//    private boolean nightSkiing;
//    private boolean freeKidsSkiing;

    public MountainStat() {};

    public MountainStat(Integer acres, Integer baseElevation, Integer peakElevation,
                        Integer numRuns, Integer numLifts, Integer numTerrainParks,
                        Integer pctBeginnerTerrain, Integer pctIntermediateTerrain,
                        Integer pctAdvancedTerrain, Integer pctExpertTerrain) {
        this.acres = acres;
        this.baseElevation = baseElevation;
        this.peakElevation = peakElevation;
        this.numRuns = numRuns;
        this.numLifts = numLifts;
        this.numTerrainParks = numTerrainParks;
        this.pctBeginnerTerrain = pctBeginnerTerrain;
        this.pctIntermediateTerrain = pctIntermediateTerrain;
        this.pctAdvancedTerrain = pctAdvancedTerrain;
        this.pctExpertTerrain = pctExpertTerrain;
    }

    public MountainStat(Integer acres, Integer baseElevation, Integer peakElevation,
                        Integer numRuns, Integer numLifts, Integer numTerrainParks,
                        Integer pctBeginnerTerrain, Integer pctIntermediateTerrain,
                        Integer pctAdvancedTerrain, Integer pctExpertTerrain, SkiResort skiResort) {

        this(acres, baseElevation, peakElevation, numRuns, numLifts, numTerrainParks,
                pctBeginnerTerrain, pctIntermediateTerrain, pctAdvancedTerrain, pctExpertTerrain);
        this.skiResort = skiResort;
    }

    // Copy Constructor
    public MountainStat(MountainStat mountainStat) {
        this.acres = mountainStat.acres;
        this.baseElevation = mountainStat.baseElevation;
        this.peakElevation = mountainStat.peakElevation;
        this.numRuns = mountainStat.numRuns;
        this.numLifts = mountainStat.numLifts;
        this.numTerrainParks = mountainStat.numTerrainParks;
        this.pctBeginnerTerrain = mountainStat.pctBeginnerTerrain;
        this.pctIntermediateTerrain = mountainStat.pctIntermediateTerrain;
        this.pctAdvancedTerrain = mountainStat.pctAdvancedTerrain;
        this.pctExpertTerrain = mountainStat.pctExpertTerrain;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        this.isDeleted = deleted;
    }

    public Integer getAcres() {
        return acres;
    }

    public void setAcres(Integer acres) {
        this.acres = acres;
    }

    public Integer getBaseElevation() {
        return baseElevation;
    }

    public void setBaseElevation(Integer baseElevation) {
        this.baseElevation = baseElevation;
    }

    public Integer getPeakElevation() {
        return peakElevation;
    }

    public void setPeakElevation(Integer peakElevation) {
        this.peakElevation = peakElevation;
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

//    public boolean isNightSkiing() {
//        return nightSkiing;
//    }
//
//    public void setNightSkiing(boolean nightSkiing) {
//        this.nightSkiing = nightSkiing;
//    }
//
//    public boolean isFreeKidsSkiing() {
//        return freeKidsSkiing;
//    }
//
//    public void setFreeKidsSkiing(boolean freeKidsSkiing) {
//        this.freeKidsSkiing = freeKidsSkiing;
//    }


    public SkiResort getSkiResort() {
        return skiResort;
    }

    public void setSkiResort(SkiResort skiResort) {
        this.skiResort = skiResort;
    }

    @Override
    public String toString() {
        return "MountainStat{" +
                "id=" + id +
                ", isDeleted=" + isDeleted +
                ", acres=" + acres +
                ", baseElevation=" + baseElevation +
                ", peakElevation=" + peakElevation +
                ", numRuns=" + numRuns +
                ", numLifts=" + numLifts +
                ", numTerrainParks=" + numTerrainParks +
                ", pctBeginnerTerrain=" + pctBeginnerTerrain +
                ", pctIntermediateTerrain=" + pctIntermediateTerrain +
                ", pctAdvancedTerrain=" + pctAdvancedTerrain +
                ", pctExpertTerrain=" + pctExpertTerrain +
//                ", skiResort=" + skiResort +
                '}';
    }

    public void setAll(MountainStat request) {
        this.setDeleted(request.getDeleted());
        this.setAcres(request.getAcres());
        this.setBaseElevation(request.getBaseElevation());
        this.setPeakElevation(request.getPeakElevation());
        this.setNumRuns(request.getNumRuns());
        this.setNumLifts(request.getNumLifts());
        this.setNumTerrainParks(request.getNumTerrainParks());
        this.setPctBeginnerTerrain(request.getPctBeginnerTerrain());
        this.setPctIntermediateTerrain(request.getPctIntermediateTerrain());
        this.setPctAdvancedTerrain(request.getPctAdvancedTerrain());
        this.setPctExpertTerrain(request.getPctExpertTerrain());
    }
}
