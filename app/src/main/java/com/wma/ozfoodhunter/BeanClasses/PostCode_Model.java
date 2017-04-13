package com.wma.ozfoodhunter.BeanClasses;

import java.util.List;

public class PostCode_Model {

    private List<Result> results = null;

    public PostCode_Model() {
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
    public class Result {

        private String st_suburb;
        private String st_postcode;


        public String getSt_suburb() {
            return st_suburb;
        }

        public void setSt_suburb(String st_suburb) {
            this.st_suburb = st_suburb;
        }

        public String getSt_postcode() {
            return st_postcode;
        }

        public void setSt_postcode(String st_postcode) {
            this.st_postcode = st_postcode;
        }
    }

}
