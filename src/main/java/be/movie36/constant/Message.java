package be.movie36.constant;

public final class Message {
    private Message() {
    }

    // Auth
    public static final String REGISTER_SUCCESS = "Đăng ký thành công";
    public static final String LOGIN_SUCCESS = "Đăng nhập thành công";
    public static final String LOGOUT_SUCCESS = "Đăng xuất thành công";
    public static final String REFRESH_SUCCESS = "Cấp token mới thành công";
    public static final String CHANGE_PASSWORD_SUCCESS = "Đổi mật khẩu thành công, vui lòng đăng nhập lại";
    public static final String EMAIL_NOT_FOUND = "Email không tìm thấy";
    public static final String LOGIN_GOOGLE_SUCCESS = "Đăng nhập Google thành công";

    // Genre
    public static final String GET_GENRE_SUCCESS = "Lấy danh sách thể loại thành công";
    public static final String GET_GENRE_BYID = "Lấy thể loại thành công";
    public static final String CREATE_GENRE_SUCCESS = "Tạo thể loại thành công";
    public static final String UPDATE_GENRE_SUCCESS = "Cập nhật thể loại thành công";
    public static final String DELETE_GENRE_SUCCESS = "Xóa thể loại thành công";

    // Actor
    public static final String GET_ACTOR_SUCCESS = "Lấy danh sách diễn viên thành công";
    public static final String GET_ACTOR_BYID = "Lấy diễn viên thành công";
    public static final String CREATE_ACTOR_SUCCESS = "Tạo diễn viên thành công";
    public static final String UPDATE_ACTOR_SUCCESS = "Cập nhật diễn viên thành công";
    public static final String DELETE_ACTOR_SUCCESS = "Xóa diễn viên thành công";

    // Common
    public static final String RESTORE_SUCCESS = "Khôi phục thành công";

    // Language
    public static final String GET_LANGUAGE_SUCCESS = "Lấy danh sách ngôn ngữ thành công";
    public static final String GET_LANGUAGE_BYID = "Lấy ngôn ngữ thành công";
    public static final String CREATE_LANGUAGE_SUCCESS = "Tạo ngôn ngữ thành công";
    public static final String UPDATE_LANGUAGE_SUCCESS = "Cập nhật ngôn ngữ thành công";
    public static final String DELETE_LANGUAGE_SUCCESS = "Xóa ngôn ngữ thành công";

    // MovieType
    public static final String GET_MOVIETYPE_SUCCESS = "Lấy danh sách loại phim thành công";
    public static final String GET_MOVIETYPE_BYID = "Lấy loại phim thành công";
    public static final String CREATE_MOVIETYPE_SUCCESS = "Tạo loại phim thành công";
    public static final String UPDATE_MOVIETYPE_SUCCESS = "Cập nhật loại phim thành công";
    public static final String DELETE_MOVIETYPE_SUCCESS = "Xóa loại phim thành công";

    // Director
    public static final String GET_DIRECTOR_SUCCESS = "Lấy danh sách đạo diễn thành công";
    public static final String GET_DIRECTOR_BYID = "Lấy đạo diễn thành công";
    public static final String CREATE_DIRECTOR_SUCCESS = "Tạo đạo diễn thành công";
    public static final String UPDATE_DIRECTOR_SUCCESS = "Cập nhật đạo diễn thành công";
    public static final String DELETE_DIRECTOR_SUCCESS = "Xóa đạo diễn thành công";
}
