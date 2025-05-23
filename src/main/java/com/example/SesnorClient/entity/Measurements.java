package com.example.SesnorClient.entity;



public class Measurements {



    private Long id;
    private float value;
    private boolean raining;
    private Sensor sensor;

    public Measurements() {
    }

    public Measurements(float value, boolean raining, Sensor sensor) {
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;

    }


    public Long getId() {
        return this.id;
    }

    public float getValue() {
        return this.value;
    }

    public boolean isRaining() {
        return this.raining;
    }

    public Sensor getSensor() {
        return this.sensor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Measurements)) return false;
        final Measurements other = (Measurements) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        if (Float.compare(this.getValue(), other.getValue()) != 0) return false;
        if (this.isRaining() != other.isRaining()) return false;
        final Object this$sensor = this.getSensor();
        final Object other$sensor = other.getSensor();
        if (this$sensor == null ? other$sensor != null : !this$sensor.equals(other$sensor)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Measurements;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        result = result * PRIME + Float.floatToIntBits(this.getValue());
        result = result * PRIME + (this.isRaining() ? 79 : 97);
        final Object $sensor = this.getSensor();
        result = result * PRIME + ($sensor == null ? 43 : $sensor.hashCode());
        return result;
    }

    public String toString() {
        return "Measurements(id=" + this.getId() + ", value=" + this.getValue() + ", raining=" + this.isRaining() + ", sensor=" + this.getSensor() + ")";
    }
}
