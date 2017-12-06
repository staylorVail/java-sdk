package com.vailsys.persephony.api.application;

import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.APIAccountRequester;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyJSONException;

import java.util.HashMap;

import static com.vailsys.persephony.json.PersyGson.gson;

/**
 * This class represents the set of wrappers around the Persephony Applications API.
 * It provides methods to handle all the operations supported by the Persephony Applications API.
 */
public class ApplicationsRequester extends APIAccountRequester {
    private static final String pathHead = "Applications";
    /** The default path for the Applications endpoint. */
    private final String path;
    /** The accountId for the acting account. */
    private final String actingAccountId;

    /**
     * Creates an ApplicationsRequester. For most SDK users ApplicationsRequesters will be created automatically by the {@link com.vailsys.persephony.api.PersyClient}
     * but is available for more advanced users who only require the features in this specific requester and not the rest of the features of the {@link com.vailsys.persephony.api.PersyClient}.
     *
     * @param credAccountId The accountId to use as authentication credentials in the HTTP Basic Auth header for requests made by this requester.
     * @param credAuthToken The authToken to use as authentication credentials in the HTTP Basic Auth header for requests made by this requester.
     * @param actingAccountId The accountId to act as. This can be the same as {@code credAccountId} or the accountId of a subaccount of the {@code credAccountId}.
     * @throws PersyException
     */
    public ApplicationsRequester(String credAccountId, String credAuthToken, String actingAccountId) throws PersyException {
        super(credAccountId, credAuthToken);
        this.actingAccountId = actingAccountId;
        this.path = APIAccountRequester.constructPath(APIAccountRequester.rootPath, this.actingAccountId, pathHead);
    }

    /**
     * Retrieve the {@code path} value generated by the ApplicationsRequester. This is the URL path used in requests to Persephony.
     *
     * @return The {@code path}.
     */
    public String getPath() {
        return path;
    }

    /**
     * Retrieve the {@code actingAccountId}.
     *
     * @return The {@code actingAccountId}.
     */
    public String getActingAccountId() {
        return actingAccountId;
    }

    private String getApplicationPath(String applicationId){
        return APIAccountRequester.constructPath(this.getPath(), applicationId);
    }

    /**
     * Allows SDK developers to change which instance of the Persephony API that the ApplicationsRequester points to.
     *
     * @param newUrl The new URL to use in place of the default APIRequester.PERSY_URL
     */
    protected void setPersyUrl(String newUrl) { super.setPersyUrl(newUrl);}

    /**
     * Retrieve a list of Applications associated with the {@code actingAccountId}.
     * This wraps a HTTP GET request to the Persephony API's
     * /Accounts/$accountId/Applications endpoint. This will retrieve all applications
     * for the acting account.
     *
     * @return An in-language representation of Persephony's paginated list
     * response. This will be a paginated list of applications as returned by
     * the Persephony API.
     */
    public ApplicationList get() throws PersyException {
        return new ApplicationList(this.getCredentialAccountId(), this.getCredentialAuthToken(), this.GET(this.getPath()));
    }

    /**
     * Retrieve a list of applications associated with the {@code actingAccountId}.
     * This wraps a HTTP GET request to the Persephony API's
     * /Accounts/$accountId/Applications endpoint. This will retrieve all applications for
     * the acting account.
     *
     * @param filters an object containing a number of possible ways to filter the applications returned by Persephony.
     *
     * @return An in-language representation of Persephony's paginated list
     * response. This will be a paginated list of applications as returned by
     * the Persephony API.
     */
    public ApplicationList get(ApplicationsSearchFilters filters) throws PersyException {
        HashMap<String, String> filtersMap;

        try{
            filtersMap = gson.fromJson(gson.toJson(filters), APIAccountRequester.GETMapType);
        } catch (JsonSyntaxException jse) {
            throw new PersyJSONException(jse);
        }

        return new ApplicationList(this.getCredentialAccountId(), this.getCredentialAuthToken(), this.GET(this.getPath(), filtersMap));
    }

    /**
     * Retrieve a single application from Persephony.
     *
     * @param applicationId The {@code applicationId} of the desired application.
     *
     * @return The application matching the {@code applicationId} provided.
     */
    public Application get(String applicationId) throws PersyException {
        return Application.fromJson(this.GET(this.getApplicationPath(applicationId)));
    }

    /**
     * Update the existing application associated with the {@code applicationId}.
     * This wraps an HTTP POST request to the Persephony API's
     * /Accounts/$accountId/Applications/$applicationId endpoint.
     *
     * @param applicationId The {@code applicationId} of the desired application.
     * @param options The {@link com.vailsys.persephony.api.application.ApplicationUpdateOptions} to change in the target application.
     *
     * @return The application matching the {@code applicationId} provided.
     *
     */
    public Application update(String applicationId, ApplicationUpdateOptions options) throws PersyException {
        return Application.fromJson(this.POST(this.getApplicationPath(applicationId), gson.toJson(options)));
    }

    /**
     * Create a new application through the Persephony API.
     * This function wraps an HTTP POST request to the Persephony API's
     * /Accounts/$accountId/Applications endpoint. This creates a new application
     * from the {@code actingAccountId}'s account.
     *
     * @return the {@link com.vailsys.persephony.api.application.Application} object
     * returned by Persephony that represents the application that was created.
     */
    public Application create() throws PersyException {
        return Application.fromJson(this.POST(this.getPath(), null));
    }

    /**
     * Create a new application through the Persephony API.
     * This function wraps an HTTP POST request to the Persephony API's
     * /Accounts/$accountId/Applications endpoint. This creates a new application
     * from the {@code actingAccountId}'s account.
     *
     * @param options Optional arguments that can be provided when creating an
     * application. See Persephony documentation for details.
     * @see com.vailsys.persephony.api.application.ApplicationCreateOptions
     *
     * @return the {@link com.vailsys.persephony.api.application.Application} object
     * returned by Persephony that represents the application that was created.
     */
    public Application create(ApplicationCreateOptions options) throws PersyException {
        return Application.fromJson(this.POST(this.getPath(), gson.toJson(options)));
    }

    /**
     * Delete the application associated with the {@code applicationId}.
     * This wraps an HTTP DELETE request to the Persephony API's
     * /Accounts/$accountId/Applications/$applicationId endpoint.
     *
     * @param applicationId The {@code applicationId} of the application to delete.
     */
    public void delete(String applicationId) throws PersyException {
        this.DELETE(this.getApplicationPath(applicationId));
    }
}
