package app.toolkit;

public interface Constants {

    final class JsonModel {
        public static final String FRIENDLY_NAME = "friendlyName";
        public static final String CONFIG_VALUES = "values";
        public static final String CONFIG_KEY = "key";
        public static final String ACTIVE = "active";
        public static final String CONTAINER_TYPE = "container_type";
        public static final String CONTAINER_PATH = "container_path";
        public static final String DESCRIPTION = "description";
        public static final String ID = "_id";
        public static final String IN = "$in";
        public static final String NAME = "name";
        public static final String OLD_VERSIONS = "old_versions";
        public static final String PARENT_ID = "parent_id";
        public static final String PARENT_PATH = "parent_path";
        public static final String ORIGIN = "origin";
        public static final String SOURCE = "source";

        private JsonModel() {

        }
    }


    final class ErrorMessage {
        public static final String UNKNOWN_ERROR = "An error occured";
        public static final String ERROR_CREATE_USER = "Error creating user";
        public static final String ERROR_GET_USER = "Error getting user";
        public static final String ERROR_UPDATE_USER = "Error updating user";
        public static final String ERROR_DELETE_USER = "Error deleting user";
        //
        public static final String ERROR_CREATE_PLANT = "Error creating plant";
        public static final String ERROR_GET_PLANT = "Error getting plant";
        public static final String ERROR_UPDATE_PLANT = "Error updating plant";
        public static final String ERROR_DELETE_PLANT = "Error deleting plant";
        //
        public static final String ERROR_CREATE_HOME = "Error creating home";
        public static final String ERROR_GET_HOME = "Error getting home";
        public static final String ERROR_UPDATE_HOME = "Error updating home";
        public static final String ERROR_DELETE_HOME = "Error deleting home";
        //
        public static final String ERROR_CREATE_ACTIONS = "Error creating action";
        public static final String ERROR_GET_ACTIONS = "Error getting action";
        public static final String ERROR_UPDATE_ACTIONS = "Error updating action";
        public static final String ERROR_DELETE_ACTIONS = "Error deleting action";

        private ErrorMessage() {

        }
    }

    final class MessageIds {
        public static final String UNKNOWN_ERROR = "api.error.unknownError";
        //
        public static final String ERROR_CREATE_USER = "api.error.createUserError";
        public static final String ERROR_GET_USER = "api.error.getUserError";
        public static final String ERROR_UPDATE_USER = "api.error.updateUserError";
        public static final String ERROR_DELETE_USER = "api.error.deleteUserError";
        //
        public static final String ERROR_CREATE_PLANT = "api.error.createPlantError";
        public static final String ERROR_GET_PLANT = "api.error.getPlantError";
        public static final String ERROR_UPDATE_PLANT = "api.error.updatePlantError";
        public static final String ERROR_DELETE_PLANT = "api.error.deletePlantError";
        //
        public static final String ERROR_CREATE_HOME = "api.error.createHomeError";
        public static final String ERROR_GET_HOME = "api.error.getHomeError";
        public static final String ERROR_UPDATE_HOME = "api.error.updateHomeError";
        public static final String ERROR_DELETE_HOME = "api.error.deleteHomeError";
        //
        public static final String ERROR_CREATE_ACTION = "api.error.createActionError";
        public static final String ERROR_GET_ACTION = "api.error.getActionError";
        public static final String ERROR_UPDATE_ACTION = "api.error.updateActionError";
        public static final String ERROR_DELETE_ACTION = "api.error.deleteActionError";

        private MessageIds() {
        }
    }

}

