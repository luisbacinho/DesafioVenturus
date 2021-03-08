package com.desafioventurus.models;

import java.util.List;

public class AdConfig {
    private List<String> safeFlags;
    private List<String> highRiskFlags;
    private List<String> unsafeFlags;
    private List<String> wallUnsafeFlags;
    private boolean showsAds;

    public AdConfig(List<String> safeFlags, List<String> highRiskFlags, List<String> unsafeFlags, List<String> wallUnsafeFlags, boolean showsAds) {
        this.safeFlags = safeFlags;
        this.highRiskFlags = highRiskFlags;
        this.unsafeFlags = unsafeFlags;
        this.wallUnsafeFlags = wallUnsafeFlags;
        this.showsAds = showsAds;
    }

    public List<String> getSafeFlags() {
        return safeFlags;
    }

    public void setSafeFlags(List<String> safeFlags) {
        this.safeFlags = safeFlags;
    }

    public List<String> getHighRiskFlags() {
        return highRiskFlags;
    }

    public void setHighRiskFlags(List<String> highRiskFlags) {
        this.highRiskFlags = highRiskFlags;
    }

    public List<String> getUnsafeFlags() {
        return unsafeFlags;
    }

    public void setUnsafeFlags(List<String> unsafeFlags) {
        this.unsafeFlags = unsafeFlags;
    }

    public List<String> getWallUnsafeFlags() {
        return wallUnsafeFlags;
    }

    public void setWallUnsafeFlags(List<String> wallUnsafeFlags) {
        this.wallUnsafeFlags = wallUnsafeFlags;
    }

    public boolean isShowsAds() {
        return showsAds;
    }

    public void setShowsAds(boolean showsAds) {
        this.showsAds = showsAds;
    }
}
