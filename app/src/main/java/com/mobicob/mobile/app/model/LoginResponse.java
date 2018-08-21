package com.mobicob.mobile.app.model;

public class LoginResponse {
        private int id;
        private String email;
        private String jwt_token;
        private String idNumber;
        private String name;
        private String lastname;
        private String position;
        private int delegationId;
        private int contractorId;
        private int roleId;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getJwt_token() {
                return jwt_token;
        }

        public void setJwt_token(String jwt_token) {
                this.jwt_token = jwt_token;
        }

        public String getIdNumber() {
                return idNumber;
        }

        public void setIdNumber(String idNumber) {
                this.idNumber = idNumber;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getLastname() {
                return lastname;
        }

        public void setLastname(String lastname) {
                this.lastname = lastname;
        }

        public String getPosition() {
                return position;
        }

        public void setPosition(String position) {
                this.position = position;
        }

        public int getDelegationId() {
                return delegationId;
        }

        public void setDelegationId(int delegationId) {
                this.delegationId = delegationId;
        }

        public int getContractorId() {
                return contractorId;
        }

        public void setContractorId(int contractorId) {
                this.contractorId = contractorId;
        }

        public int getRoleId() {
                return roleId;
        }

        public void setRoleId(int roleId) {
                this.roleId = roleId;
        }
}
