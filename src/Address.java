public class Address {
    private final String street;
    private final Integer houseNumber;
    private final Character houseLiter;
    private final Integer building;
    private final Integer flat;

    public Address(String street, Integer houseNumber, Character houseLiter, Integer building, Integer flat) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.houseLiter = houseLiter;
        this.building = building;
        this.flat = flat;
    }

    public String getStreet() {
        return street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public Character getHouseLiter() {
        return houseLiter;
    }

    public Integer getBuilding() {
        return building;
    }

    public Integer getFlat() {
        return flat;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", houseLiter=" + houseLiter +
                ", building=" + building +
                ", flat=" + flat +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String street;
        private Integer houseNumber;
        private Character houseLiter;
        private Integer building;
        private Integer flat;

        public Builder withStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder withHouseNumber(Integer houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public Builder withHouseLiter(Character houseLiter) {
            this.houseLiter = houseLiter;
            return this;
        }

        public Builder withBuilding(Integer building) {
            this.building = building;
            return this;
        }

        public Builder withFlat(Integer flat) {
            this.flat = flat;
            return this;
        }

        public Address build() {
            return new Address(street, houseNumber,
                    houseLiter, building, flat);
        }
    }
}
