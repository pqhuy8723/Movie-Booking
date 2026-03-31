# Movie Booking System (Fullstack)

## Giới thiệu

Movie Booking System là một hệ thống đặt vé xem phim được xây dựng theo kiến trúc fullstack, bao gồm backend API và frontend client (đang phát triển).

Dự án tập trung vào:

* Xây dựng RESTful API với Spring Boot
* Xác thực & phân quyền bằng JWT
* Thiết kế hệ thống theo hướng thực tế (production-ready)

---

## Kiến trúc hệ thống

```text
Frontend (React)
        ↓
   REST API (Spring Boot)
        ↓
      MySQL Database
```

---

## Công nghệ sử dụng

### Backend

* Java 17
* Spring Boot
* Spring Security
* JWT (Authentication & Authorization)
* MySQL
* Maven

---

### Frontend (Planned)

* React (Web) / React Native (Mobile)
* Axios / Fetch API
* Context API (Auth Management)

---

## Tính năng chính

### 👤 Authentication

* Đăng ký tài khoản
* Đăng nhập (JWT)
* Xác thực qua token

---

### Authorization

* Phân quyền USER / ADMIN
* Bảo vệ API theo role

---

### (Đang phát triển)

* Quản lý phim
* Danh sách phim
* Đặt vé

---

## Cấu trúc project

### Backend

```text
be.movie36
├── controller
├── service
├── repository
├── entity
├── security
└── exception
```

### Frontend (planned)

```text
src/
├── api/
├── pages/
├── components/
├── context/
└── hooks/
```

---

## Cài đặt & chạy project

### 1. Clone project

```bash
git clone https://github.com/your-username/movie-booking-api.git
cd movie-booking-api
```

---

### 2. Cấu hình database

```sql
CREATE DATABASE movie_booking;
```

---

### 3. Cấu hình `application.yml`

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/movie_booking
    username: your_username
    password: your_password

jwt:
  secret: ${JWT_SECRET}
  expiration-time: 86400000
```

---

### 4. Thiết lập biến môi trường

#### Windows

```bash
set JWT_SECRET=your_base64_secret_key
```

#### Mac/Linux

```bash
export JWT_SECRET=your_base64_secret_key
```

---

### 5. Chạy backend

```bash
mvn spring-boot:run
```

---

##  API Authentication

### Register

```http
POST /api/auth/register
```

### Login

```http
POST /api/auth/login
```

Response trả về JWT token

Sử dụng token:

```http
Authorization: Bearer <your_token>
```

---

## Kết nối Frontend

Frontend sẽ:

1. Gọi API login
2. Nhận JWT token
3. Lưu token (localStorage / AsyncStorage)
4. Gửi token trong mỗi request

---

##  Test API

* Postman
* Thunder Client

---

## Roadmap phát triển

### Phase 1

* [x] Authentication (JWT)
* [x] Authorization

### Phase 2

* [ ] CRUD Movie
* [ ] API danh sách phim

### Phase 3

* [ ] Booking ticket
* [ ] Payment integration

### Phase 4

* [ ] Frontend hoàn chỉnh
* [ ] Deploy hệ thống

---

## Bảo mật

* Sử dụng JWT để xác thực
* Secret key được lưu qua biến môi trường
* Token có thời gian hết hạn

---

##  Tác giả

* Phạm Quang Huy

---

##  Mục tiêu project

* Nâng cao kỹ năng backend với Spring Boot
* Hiểu rõ JWT & Spring Security
* Xây dựng hệ thống fullstack thực tế

---

## Ghi chú

Project đang trong quá trình phát triển và sẽ được cập nhật thêm các tính năng trong thời gian tới.
