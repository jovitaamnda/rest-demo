    package com.thinkconstructive.rest_demo.model;

    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.persistence.Table;

    @Entity
    @Table(name = "employees") // pastikan nama tabel sama persis dengan yang di MySQL
    public class Employee {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "employee_name")
        private String employee_name;

        @Column(name = "employee_salary")
        private double employee_salary;

        @Column(name = "employee_age")
        private int employee_age;

        @Column(name = "profile_image")
        private String profile_image;

        // Jika kamu ingin pakai kolom tambahan name, position, salary juga bisa ditambahkan di sini.
        // Tapi karena kamu minta dihapus sebelumnya, bagian ini tidak disertakan.

        // === GETTERS & SETTERS ===

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmployee_name() {
            return employee_name;
        }

        public void setEmployee_name(String employee_name) {
            this.employee_name = employee_name;
        }

        public double getEmployee_salary() {
            return employee_salary;
        }

        public void setEmployee_salary(double employee_salary) {
            this.employee_salary = employee_salary;
        }

        public int getEmployee_age() {
            return employee_age;
        }

        public void setEmployee_age(int employee_age) {
            this.employee_age = employee_age;
        }

        public String getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(String profile_image) {
            this.profile_image = profile_image;
        }
    }
