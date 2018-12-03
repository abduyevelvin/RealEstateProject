package re.util;

public class SQLMapping {

    public static final String GET_HOUSE_LIST  = "SELECT ha.id, c.id, c.name, d.id, d.name, room_nr, area, address, contact, price, a.id, a.type, ct.id, ct.type, \r\n" +
                "u.id, u.name, u.surname FROM HOUSE_ANNOUNCEMENT ha JOIN CITY c ON ha.city_id = c.id JOIN DISTRICT d ON ha.district_id = d.id \r\n" +
                "JOIN ANNOUNCEMENT_TYPE a ON ha.announcement_id = a.id JOIN CONTACT_TYPE ct ON ha.contact_id = ct.id \r\n" +
                "JOIN USERS u ON ha.user_id = u.id WHERE ha.active = 1";

    public static final String GET_HOUSE_LIST_PROC = "{call GET_HOUSE_ANNOUNCE_LIST_FUNC}";

    public static final String GET_PROPERTY_LIST = "SELECT pa.id, c.id, c.name, d.id, d.name, room_nr, area, address, contact, price, a.id, a.type, ct.id, ct.type, u.id, u.name, u.surname \r\n" +
                "FROM PROPERTY_ANNOUNCEMENT pa JOIN CITY c ON pa.city_id = c.id JOIN DISTRICT d ON pa.district_id = d.id \r\n" +
                "JOIN ANNOUNCEMENT_TYPE a ON pa.announcement_id = a.id JOIN CONTACT_TYPE ct ON pa.contact_id = ct.id \r\n" +
                "JOIN USERS u ON pa.user_id = u.id WHERE pa.active = 1";

    public static final String GET_GROUND_LIST = "SELECT sa.id, c.id, c.name, d.id, d.name, area, address, contact, price, a.id, a.type, ct.id, ct.type, u.id, u.name, u.surname \r\n" +
                "FROM SOIL_ANNOUNCEMENT sa JOIN CITY c ON sa.city_id = c.id \r\n JOIN DISTRICT d ON sa.district_id = d.id \r\n" +
                "JOIN ANNOUNCEMENT_TYPE a ON sa.announcement_id = a.id \r\n" +
                "JOIN CONTACT_TYPE ct ON sa.contact_id = ct.id \r\n JOIN USERS u ON sa.user_id = u.id WHERE sa.active = 1";

    public static final String GET_CITY_LIST = "SELECT id, name FROM CITY WHERE active = 1";

    public static final String GET_GENDERS_LIST = "SELECT id, gender FROM GENDERS WHERE active = 1";

    public static final String GET_QUESTIONS_LIST = "SELECT id, question FROM QUESTIONS WHERE active = 1";

    public static final String GET_ROLES_LIST = "SELECT id, role FROM ROLES WHERE active = 1";

    public static final String GET_DISTRICT_LIST = "SELECT id, name FROM DISTRICT WHERE active = 1";

    public static final String GET_DISTRICT_LIST_BY_CITY_ID = "SELECT id, name FROM DISTRICT WHERE active = 1 and city_id = ?";

    public static final String GET_ANNOUNCE_TYPE_LIST = "SELECT id, type FROM ANNOUNCEMENT_TYPE WHERE active = 1";

    public static final String GET_CONTACT_TYPE_LIST = "SELECT id, type FROM CONTACT_TYPE WHERE active = 1";

    public static final String GET_USERS_LIST = "SELECT u.id, u.name, u.surname, u.username, u.email, u.password, u.dob, g.id, g.gender, q.id, q.question, u.answer, r.id, r.role, u.active\n" +
            "FROM USERS u JOIN GENDERS g ON u.gender_id = g.id\n" +
            "JOIN QUESTIONS q ON u.question_id = q.id\n" +
            "JOIN ROLES r ON u.role_id = r.id\n";

    public static final String ADD_HOUSE_ANNOUNCE = "INSERT INTO HOUSE_ANNOUNCEMENT(city_id, district_id, room_nr, area, address, contact, price, announcement_id, contact_id, user_id) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String ADD_HOUSE_ANNOUNCE_PROC = "{call ADD_HOUSE_ANNOUNCE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

    public static final String GET_HOUSE_LIST_BY_ID  = "SELECT ha.id, c.id, c.name, d.id, d.name, room_nr, area, address, contact, price, a.id, a.type, ct.id, ct.type, \r\n" +
            "u.id, u.name, u.surname FROM HOUSE_ANNOUNCEMENT ha JOIN CITY c ON ha.city_id = c.id JOIN DISTRICT d ON ha.district_id = d.id \r\n" +
            "JOIN ANNOUNCEMENT_TYPE a ON ha.announcement_id = a.id JOIN CONTACT_TYPE ct ON ha.contact_id = ct.id \r\n" +
            "JOIN USERS u ON ha.user_id = u.id WHERE ha.id = ?";

    public static final String GET_HOUSE_LIST_BY_ID_PROC = "{call GET_HOUSE_ANNOUNCE_LIST_BY_ID_FUNC(?)}";

    public static final String UPDATE_HOUSE_ANNOUNCE = "UPDATE HOUSE_ANNOUNCEMENT SET city_id = ?, district_id = ?, room_nr = ?, area = ?, address = ?, contact = ?, price = ?, " +
            "announcement_id = ?, contact_id = ?, user_id = ? WHERE id = ?";

    public static final String DELETE_HOUSE_ANNOUNCE = "UPDATE HOUSE_ANNOUNCEMENT SET active = 0 WHERE id = ?";

    public static final String APPROVE_USER = "UPDATE USERS SET active = 1 WHERE id = ?";

    public static final String SEARCH_HOUSE_ANNOUNCE = "SELECT ha.id, c.id, c.name, d.id, d.name, room_nr, area, address, contact, price, a.id, a.type, ct.id, ct.type, \r\n" +
            "u.id, u.name, u.surname FROM HOUSE_ANNOUNCEMENT ha JOIN CITY c ON ha.city_id = c.id JOIN DISTRICT d ON ha.district_id = d.id \r\n" +
            "JOIN ANNOUNCEMENT_TYPE a ON ha.announcement_id = a.id JOIN CONTACT_TYPE ct ON ha.contact_id = ct.id \r\n" +
            "JOIN USERS u ON ha.user_id = u.id WHERE ha.active = 1 AND (LOWER(c.name) LIKE LOWER(?) \r\n" +
            "OR LOWER(d.name) LIKE LOWER(?) OR LOWER(address) LIKE LOWER(?) OR LOWER(ct.type) LIKE LOWER(?) \r\n" +
            "OR LOWER(ha.contact) LIKE LOWER(?) OR LOWER(u.name) LIKE LOWER(?) OR LOWER(u.surname) LIKE LOWER(?))";

    public static final String LOGIN_USERS = "SELECT u.id, u.name, u.surname, u.username, u.email, r.id, r.role \n" +
            "FROM USERS u JOIN ROLES r on r.id = u.role_id \n" +
            "WHERE u.active = 1 and u.username = ? and u.password = ?";

    public static final String REGISTRATION_USERS = "INSERT INTO USERS(name, surname, username, password, confirm_password, gender_id, dob, email, question_id, answer, role_id, admin_code, active) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 2)";

    public static final String CHECK_USER_NAME = "SELECT * FROM USERS WHERE username = ?";

    public static final String COUNT_NEW_USERS = "SELECT COUNT(*) AS NEW_USER FROM USERS WHERE active = 2";
}
