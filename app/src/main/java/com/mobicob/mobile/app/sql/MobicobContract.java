package com.mobicob.mobile.app.sql;

import android.provider.BaseColumns;

public final class MobicobContract {
    private MobicobContract() {}

    /* Inner class that defines the table contents */
    public static class FeedUsers implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_USER_NAME = "user_name";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_LAST_NAME = "lastname";
        public static final String COLUMN_NAME_CREATION = "creation";
        public static final String COLUMN_NAME_ID_NUMBER = "id_number";
        public static final String COLUMN_NAME_CONTRACTOR_ID = "contractor_id";
        public static final String COLUMN_NAME_ROLE_ID = "role_id";
        public static final String COLUMN_NAME_PHONE = "phone";
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_ACTIVE = "active";
        public static final String COLUMN_NAME_LATITUDE = "latitude";
        public static final String COLUMN_NAME_LONGITUDE = "longitude";
        public static final String COLUMN_NAME_DELEGATION_ID = "delegation_id";
        public static final String COLUMN_NAME_POSITION = "position";


        public static final String SQL_CREATE_USERS =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID                       + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_ID            + " INTEGER," +
                        COLUMN_NAME_USER_NAME     + " TEXT," +
                        COLUMN_NAME_EMAIL         + " TEXT," +
                        COLUMN_NAME_PASSWORD      + " TEXT," +
                        COLUMN_NAME_NAME          + " TEXT," +
                        COLUMN_NAME_LAST_NAME     + " TEXT," +
                        COLUMN_NAME_CREATION      + " TEXT," +
                        COLUMN_NAME_ID_NUMBER     + " INTEGER," +
                        COLUMN_NAME_CONTRACTOR_ID + " INTEGER," +
                        COLUMN_NAME_ROLE_ID       + " INTEGER," +
                        COLUMN_NAME_PHONE         + " TEXT," +
                        COLUMN_NAME_ADDRESS       + " TEXT," +
                        COLUMN_NAME_ACTIVE        + " INTEGER," +
                        COLUMN_NAME_LATITUDE      + " TEXT," +
                        COLUMN_NAME_LONGITUDE     + " TEXT," +
                        COLUMN_NAME_DELEGATION_ID + " INTEGER," +
                        COLUMN_NAME_POSITION      + " TEXT )";

        public static final String SQL_DELETE_USERS =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class FeedCampaigns implements BaseColumns {
        public static final String TABLE_NAME = "campaigns";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NUMBER = "number";
        public static final String COLUMN_NAME_SOURCE = "source";
        public static final String COLUMN_NAME_STATE = "state";
        public static final String COLUMN_NAME_INIT_DATE = "init_date";
        public static final String COLUMN_NAME_FINISH_DATE = "finish_date";

        public static final String SQL_CREATE_CAMPAINGS =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID                       + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_ID            + " INTEGER," +
                        COLUMN_NAME_NUMBER        + " INTEGER," +
                        COLUMN_NAME_SOURCE        + " TEXT," +
                        COLUMN_NAME_STATE         + " TEXT," +
                        COLUMN_NAME_INIT_DATE     + " TEXT," +
                        COLUMN_NAME_FINISH_DATE   + " TEXT )";

        public static final String SQL_DELETE_CAMPAINGS =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class FeedTasks implements BaseColumns {
        public static final String TABLE_NAME = "tasks";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_PERIOD = "period";
        public static final String COLUMN_NAME_PLAN = "plan";
        public static final String COLUMN_NAME_VALIDITY = "validity";
        public static final String COLUMN_NAME_CAMPAIGN_ID = "campaign_id";
        public static final String COLUMN_NAME_CLIENT_ID = "client_id";
        public static final String COLUMN_NAME_USER_ID = "user_id";
        public static final String COLUMN_NAME_DUE_DATE = "due_date";
        public static final String COLUMN_NAME_ESTIMATED_DATE = "estimated_time";
        public static final String COLUMN_NAME_MANAGEMENT_DATE = "management_date";
        public static final String COLUMN_NAME_MANAGEMENT_TYPE_ID = "management_type_id";
        public static final String COLUMN_NAME_RESULT_TYPE_ID = "result_type_id";
        public static final String COLUMN_NAME_ANOMALY_TYPE_ID = "anomaly_type_id";
        public static final String COLUMN_NAME_COLLECTION_ENTITY = "collection_entity";
        public static final String COLUMN_NAME_PAYMENT_DATE = "payment_date";
        public static final String COLUMN_NAME_COMMITMENT_DATE = "commitment_date";
        public static final String COLUMN_NAME_PERSONAL_CONTACT = "personal_contact";
        public static final String COLUMN_NAME_ID_NUMBER = "id_number";
        public static final String COLUMN_NAME_PAYMENT_HOLDER = "payment_holder";
        public static final String COLUMN_NAME_PHONE = "phone";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_OBSERVATIONS = "observations";
        public static final String COLUMN_NAME_READING_SIGNATURE = "reading_signature";
        public static final String COLUMN_NAME_DATAPHONE_PAYMENT = "dataphone_payment";
        public static final String COLUMN_NAME_USED_TIME = "used_time";
        public static final String COLUMN_NAME_LATITUDE = "latitude";
        public static final String COLUMN_NAME_LONGITUDE = "longitude";

        public static final String SQL_CREATE_TASKS =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID                             + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_ID                  + " INTEGER," +
                        COLUMN_NAME_PERIOD              + " INTEGER," +
                        COLUMN_NAME_PLAN                + " TEXT," +
                        COLUMN_NAME_VALIDITY            + " TEXT," +
                        COLUMN_NAME_CAMPAIGN_ID         + " INTEGER," +
                        COLUMN_NAME_CLIENT_ID           + " INTEGER," +
                        COLUMN_NAME_USER_ID             + " INTEGER," +
                        COLUMN_NAME_DUE_DATE            + " TEXT," +
                        COLUMN_NAME_ESTIMATED_DATE      + " TEXT," +
                        COLUMN_NAME_MANAGEMENT_DATE     + " TEXT," +
                        COLUMN_NAME_MANAGEMENT_TYPE_ID  + " INTEGER," +
                        COLUMN_NAME_RESULT_TYPE_ID      + " INTEGER," +
                        COLUMN_NAME_ANOMALY_TYPE_ID     + " INTEGER," +
                        COLUMN_NAME_COLLECTION_ENTITY   + " TEXT," +
                        COLUMN_NAME_PAYMENT_DATE        + " TEXT," +
                        COLUMN_NAME_COMMITMENT_DATE     + " TEXT," +
                        COLUMN_NAME_PERSONAL_CONTACT    + " INTEGER," +
                        COLUMN_NAME_ID_NUMBER           + " INTEGER," +
                        COLUMN_NAME_PAYMENT_HOLDER      + " TEXT," +
                        COLUMN_NAME_PHONE               + " TEXT," +
                        COLUMN_NAME_EMAIL               + " TEXT," +
                        COLUMN_NAME_OBSERVATIONS        + " TEXT," +
                        COLUMN_NAME_READING_SIGNATURE   + " INTEGER," +
                        COLUMN_NAME_DATAPHONE_PAYMENT   + " INTEGER," +
                        COLUMN_NAME_USED_TIME           + " TEXT," +
                        COLUMN_NAME_LATITUDE            + " TEXT," +
                        COLUMN_NAME_LONGITUDE           + " TEXT )";

        public static final String SQL_DELETE_TASKS =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class FeedClients implements BaseColumns {
        public static final String TABLE_NAME = "campaigns";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NIC = "NIC";
        public static final String COLUMN_NAME_UNICOM = "unicom";
        public static final String COLUMN_NAME_DELEGATION_ID = "delegation_id";
        public static final String COLUMN_NAME_NIS = "NIS";
        public static final String COLUMN_NAME_DEPARTAMENT = "departament";
        public static final String COLUMN_NAME_MUNICIPALITY = "municipality";
        public static final String COLUMN_NAME_CORREGIMIENTO = "corregimiento";
        public static final String COLUMN_NAME_NEIGHBORHOOD = "neighborhood";
        public static final String COLUMN_NAME_STREET_TYPE = "street_type";
        public static final String COLUMN_NAME_STREET_NAME = "street_name";
        public static final String COLUMN_NAME_DUPLICATOR = "duplicator";
        public static final String COLUMN_NAME_NUMBER = "number";
        public static final String COLUMN_NAME_CGV = "CGV";
        public static final String COLUMN_NAME_ADDRESS = "address";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_ID_NUMBER = "id_number";
        public static final String COLUMN_NAME_PHONE = "phone";
        public static final String COLUMN_NAME_RATE = "rate";
        public static final String COLUMN_NAME_STATE = "state";
        public static final String COLUMN_NAME_ROUTE = "route";
        public static final String COLUMN_NAME_READING_ITINERARY = "reading_itinerary";
        public static final String COLUMN_NAME_AOL = "AOL";
        public static final String COLUMN_NAME_MEASURER = "measurer";
        public static final String COLUMN_NAME_MEASURER_TYPE = "measurer_type";
        public static final String COLUMN_NAME_MEASURER_BRAND = "measurer_brand";
        public static final String COLUMN_NAME_ENERGY_DEBT = "energy_debt";
        public static final String COLUMN_NAME_IRREGULAR_DEBT = "irregular_debt";
        public static final String COLUMN_NAME_THIRD_PARTY_DEBT = "third_party_debt";
        public static final String COLUMN_NAME_FINANCED_DEBT = "financed_debt";
        public static final String COLUMN_NAME_OVERDUE_BILLS = "overdue_bills";
        public static final String COLUMN_NAME_AGREED_BILLS = "agreed_bills";

        public static final String SQL_CREATE_CLIENTS =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID                             + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_ID                  + " INTEGER," +
                        COLUMN_NAME_NIC                 + " INTEGER," +
                        COLUMN_NAME_UNICOM              + " TEXT," +
                        COLUMN_NAME_DELEGATION_ID       + " INTEGER," +
                        COLUMN_NAME_NIS                 + " INTEGER," +
                        COLUMN_NAME_DEPARTAMENT         + " TEXT," +
                        COLUMN_NAME_MUNICIPALITY        + " TEXT," +
                        COLUMN_NAME_CORREGIMIENTO       + " TEXT," +
                        COLUMN_NAME_NEIGHBORHOOD        + " TEXT," +
                        COLUMN_NAME_STREET_TYPE         + " TEXT," +
                        COLUMN_NAME_STREET_NAME         + " TEXT," +
                        COLUMN_NAME_DUPLICATOR          + " TEXT," +
                        COLUMN_NAME_NUMBER              + " INTEGER," +
                        COLUMN_NAME_CGV                 + " TEXT," +
                        COLUMN_NAME_ADDRESS             + " TEXT," +
                        COLUMN_NAME_NAME                + " TEXT," +
                        COLUMN_NAME_ID_NUMBER           + " INTEGER," +
                        COLUMN_NAME_PHONE               + " TEXT," +
                        COLUMN_NAME_RATE                + " TEXT," +
                        COLUMN_NAME_STATE               + " TEXT," +
                        COLUMN_NAME_ROUTE               + " INTEGER," +
                        COLUMN_NAME_READING_ITINERARY   + " INTEGER," +
                        COLUMN_NAME_AOL                 + " INTEGER," +
                        COLUMN_NAME_MEASURER            + " TEXT," +
                        COLUMN_NAME_MEASURER_TYPE       + " TEXT," +
                        COLUMN_NAME_MEASURER_BRAND      + " TEXT," +
                        COLUMN_NAME_ENERGY_DEBT         + " INTEGER," +
                        COLUMN_NAME_IRREGULAR_DEBT      + " INTEGER," +
                        COLUMN_NAME_THIRD_PARTY_DEBT    + " INTEGER," +
                        COLUMN_NAME_FINANCED_DEBT       + " INTEGER," +
                        COLUMN_NAME_OVERDUE_BILLS       + " INTEGER," +
                        COLUMN_NAME_AGREED_BILLS        + " INTEGER )";

        public static final String SQL_DELETE_CLIENTS =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class FeedContractors implements BaseColumns {
        public static final String TABLE_NAME = "contractors";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_CODE = "code";
        public static final String COLUMN_NAME_NAME = "name";


        public static final String SQL_CREATE_CONTRACTORS =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID                 + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_ID      + " INTEGER," +
                        COLUMN_NAME_CODE    + " TEXT," +
                        COLUMN_NAME_NAME    + " TEXT )";

        public static final String SQL_DELETE_CONTRACTORS =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class FeedDelegations implements BaseColumns {
        public static final String TABLE_NAME = "delegations";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_CODE = "code";
        public static final String COLUMN_NAME_NAME = "name";

        public static final String SQL_CREATE_DELEGATIONS =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID                 + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_ID      + " INTEGER," +
                        COLUMN_NAME_CODE    + " TEXT," +
                        COLUMN_NAME_NAME    + " TEXT )";

        public static final String SQL_DELETE_DELEGATIONS =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class FeedMagementTypes implements BaseColumns {
        public static final String TABLE_NAME = "management_types";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_CODE = "code";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_DESCRIPTION = "description";

        public static final String SQL_CREATE_MANAGEMENT_TYPES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID                     + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_ID          + " INTEGER," +
                        COLUMN_NAME_CODE        + " TEXT," +
                        COLUMN_NAME_NAME        + " TEXT," +
                        COLUMN_NAME_DESCRIPTION + " TEXT )";

        public static final String SQL_DELETE_MANAGEMENT_TYPES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class FeedResultTypes implements BaseColumns {
        public static final String TABLE_NAME = "result_types";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_CODE = "code";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_DESCRIPTION = "description";

        public static final String SQL_CREATE_RESULT_TYPES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID                     + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_ID          + " INTEGER," +
                        COLUMN_NAME_CODE        + " TEXT," +
                        COLUMN_NAME_NAME        + " TEXT," +
                        COLUMN_NAME_DESCRIPTION + " TEXT )";

        public static final String SQL_DELETE_RESULT_TYPES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class FeedAnomalyTypes implements BaseColumns {
        public static final String TABLE_NAME = "anomaly_types";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_CODE = "code";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_DESCRIPTION = "description";

        public static final String SQL_CREATE_ANOMALY_TYPES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID                     + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_ID          + " INTEGER," +
                        COLUMN_NAME_CODE        + " TEXT," +
                        COLUMN_NAME_NAME        + " TEXT," +
                        COLUMN_NAME_DESCRIPTION + " TEXT )";

        public static final String SQL_DELETE_ANOMALY_TYPES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class FeedRoles implements BaseColumns {
        public static final String TABLE_NAME = "roles";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_CODE = "code";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_DESCRIPTION = "description";

        public static final String SQL_CREATE_ROLES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID                     + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_ID          + " INTEGER," +
                        COLUMN_NAME_CODE        + " TEXT," +
                        COLUMN_NAME_NAME        + " TEXT," +
                        COLUMN_NAME_DESCRIPTION + " TEXT )";

        public static final String SQL_DELETE_ROLES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

}