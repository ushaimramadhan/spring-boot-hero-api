# Spring Boot Hero API

Project ini adalah **RESTful API** sederhana untuk mengelola data karakter (Hero) dalam sebuah game RPG. Project ini dibuat sebagai latihan implementasi **Backend Development** modern menggunakan Java dan Spring Boot.

## Tech Stack

Project ini dibangun menggunakan teknologi terkini:
* **Language:** Java 25 (LTS)
* **Framework:** Spring Boot 3.4.0
* **Database:** PostgreSQL
* **Build Tool:** Maven

## Fitur & Arsitektur

Aplikasi ini menerapkan **Layered Architecture** untuk menjaga kode tetap bersih dan terstruktur:

1.  **Controller Layer:** Menangani HTTP Request dan Response.
2.  **Service Layer:** Menangani Logika Bisnis (misal: penentuan Role "Sepuh" vs "Pemula").
3.  **Repository Layer:** Menangani komunikasi ke Database (PostgreSQL).
4.  **DTO (Data Transfer Object):** Memisahkan data input user dengan Entity database.
5.  **Global Exception Handling:** Menangani error validasi agar response JSON tetap rapi.

## Cara Menjalankan (Local)

### Prasyarat
Pastikan di komputer Anda sudah terinstall:
* Java JDK 21 atau lebih baru (Disarankan Java 25)
* PostgreSQL
* Maven

### Langkah Instalasi

1.  **Clone Repository**
    ```bash
    git clone [https://github.com/USERNAME_ANDA/spring-boot-hero-api.git](https://github.com/USERNAME_ANDA/spring-boot-hero-api.git)
    cd spring-boot-hero-api
    ```

2.  **Setup Database**
    Buat database baru di PostgreSQL Anda:
    ```sql
    CREATE DATABASE demo_spring;
    ```

3.  **Konfigurasi Aplikasi**
    Buka `src/main/resources/application.properties` dan sesuaikan dengan kredensial database lokal Anda:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/demo_spring
    spring.datasource.username=postgres
    spring.datasource.password=password_anda
    ```

4.  **Jalankan Aplikasi**
    ```bash
    ./mvnw spring-boot:run
    ```

Aplikasi akan berjalan di `http://localhost:8080`.

## Dokumentasi API

Berikut adalah daftar Endpoint yang tersedia:

| Method | Endpoint | Deskripsi | Contoh Request Body |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/heroes` | Mengambil semua data hero | - |
| `GET` | `/api/heroes/{id}` | Mengambil detail 1 hero | - |
| `POST` | `/api/heroes` | Membuat hero baru (Validasi aktif) | `{ "name": "Zilong", "level": 15 }` |
| `PUT` | `/api/heroes/{id}` | Update data hero | `{ "name": "Zilong Elite", "level": 50 }` |
| `DELETE` | `/api/heroes/{id}` | Menghapus hero | - |

### Contoh Response Validasi (Error Handling)
Jika input tidak sesuai (misal nama kosong), API akan mereturn:
```json
{
    "name": "Nama Hero tidak boleh kosong, Bos!",
    "level": "Level minimal 1 dong, masa minus?"
}
```
## Catatan Pembelajaran

- Selama pengerjaan project ini, saya mempelajari konsep:

- Dependency Injection (@Autowired): Membiarkan Spring mengatur pembuatan objek.

- JPA/Hibernate: Membuat query database tanpa menulis SQL manual.

- DTO Pattern: Pentingnya memisahkan Entity database dengan Input user untuk keamanan.
