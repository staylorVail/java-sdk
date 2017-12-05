package com.vailsys.persephony.api.phoneNumber;

import com.google.gson.JsonSyntaxException;
import com.vailsys.persephony.api.APIAccountRequester;
import com.vailsys.persephony.api.PersyException;
import com.vailsys.persephony.api.PersyJSONException;
import com.vailsys.persephony.log.LogWriter;

import java.util.HashMap;

import static com.vailsys.persephony.json.PersyGson.gson;

/**
 * This class represents the set of wrappers around the Persephony CallingNumbers API.
 * It provides methods to handle all the operations supported by the Persephony CallingNumbers API.
 */
public class CallingNumberRequester extends APIAccountRequester {

    private static final String pathHead = "CallingNumbers";
    /** The default path for the CallingNumbers endpoint. */
    private final String path;
    /** The accountId for the acting account. */
    private final String actingAccountId;

    /**
     * Creates a CallingNumberRequester with custom logging settings. For most SDK users CallingNumberRequesters will be created automatically by the {@link com.vailsys.persephony.api.PersyClient} but is available for more advanced users who only require the features in this specific requester and not the rest of the features of the {@link com.vailsys.persephony.api.PersyClient}.
     *
     * @param credAccountId   The accountId to use as authentication credentials
     * in the HTTP Basic Auth header for requests made by this requester.
     * @param credAuthToken   The authToken to use as authentication credentials
     * in the HTTP Basic Auth header for requests made by this requester.
     * @param actingAccountId The accountId to act as. This can be the same as
     * {@code credAccountId} or the accountId of a subaccount of the {@code credAccountId}.
     * @param writer The log writer to use.
     */
    public CallingNumberRequester(String credAccountId, String credAuthToken, String actingAccountId, LogWriter writer) throws PersyException {
        super(credAccountId, credAuthToken, writer);
        this.actingAccountId = actingAccountId;
        this.path = APIAccountRequester.constructPath(APIAccountRequester.rootPath, this.actingAccountId, this.pathHead);
    }

    /**
     * Creates a CallingNumberRequester. For most SDK users CallingNumberRequesters will be created automatically by the {@link com.vailsys.persephony.api.PersyClient} but is available for more advanced users who only require the features in this specific requester and not the rest of the features of the {@link com.vailsys.persephony.api.PersyClient}.
     *
     * @param credAccountId   The accountId to use as authentication credentials
     * in the HTTP Basic Auth header for requests made by this requester.
     * @param credAuthToken   The authToken to use as authentication credentials
     * in the HTTP Basic Auth header for requests made by this requester.
     * @param actingAccountId The accountId to act as. This can be the same as
     * {@code credAccountId} or the accountId of a subaccount of the {@code credAccountId}.
     */
    public CallingNumberRequester(String credAccountId, String credAuthToken, String actingAccountId) throws PersyException {
        super(credAccountId, credAuthToken);
        this.actingAccountId = actingAccountId;
        this.path = APIAccountRequester.constructPath(APIAccountRequester.rootPath, this.actingAccountId, this.pathHead);
    }

    /**
     * Retrieve the {@code path} value generated by the CallingNumberRequester. This is
     * the URL path used in requests to Persephony.
     *
     * @return The {@code path}.
     */
    public String getPath() {
        return path;
    }

    private String getCallingNumberPath(String callingNumberId){
        return APIAccountRequester.constructPath(this.getPath(), callingNumberId);
    }

    /**
     * Retrieve the {@code actingAccountId}.
     *
     * @return The {@code actingAccountId}.
     */
    public String getActingAccountId() {
        return actingAccountId;
    }

    /**
     * Allows SDK developers to change which instance of the Persephony API that the CallingNumberRequester points to.
     *
     * @param newUrl The new URL to use in place of the default APIRequester.PERSY_URL
     */
    protected void setPersyUrl(String newUrl){ super.setPersyUrl(newUrl);}

    /**
     * Create a new CallingNumber through the Persephony API.
     * This function wraps an HTTP POST request to the Persephony API's /Account/$accountId/CallingNumbers endpoint. This creates a new calling number from the {@code actingAccountId}'s account.
     *
     * @param options Required and optional arguments that can be provided when creating a calling number. See Persephony documentation for details.
     * @see com.vailsys.persephony.api.phoneNumber.CallingNumberCreateOptions
     * @return The {@link com.vailsys.persephony.api.phoneNumber.CallingNumber} object returned by Persephony that represents the calling number that was created.
     */
    public CallingNumber create(CallingNumberCreateOptions options) throws PersyException{
        return CallingNumber.fromJson(this.POST(this.getPath(), gson.toJson(options)));
    }

    /**
     * Delete a CallingNumber through the Persephony API.
     * This function wraps an HTTP DELETE request to the Persephony API's /Account/$accountId/CallingNumbers/$callingNumberId endpoint.
     *
     * @param callingNumberId The {@code callingNumberId} of the calling number to delete.
     */
    public void delete(String callingNumberId) throws PersyException{
        this.DELETE(this.getCallingNumberPath(callingNumberId));
    }

    /**
     * Retrieve a single calling number from Persephony.
     *
     * @param callingNumberId The {@code callingNumberId} of the desired calling number.
     * @return The calling number matching the {@code callingNumberId} provided.
     */
    public CallingNumber get(String callingNumberId) throws PersyException {
        return CallingNumber.fromJson(this.GET(this.getCallingNumberPath(callingNumberId)));
    }

    /**
     * Update the existing calling number associated with the {@code callingNumberId}. This wraps an HTTP POST to the Persephony API's /Accounts/$accountId/CallingNumbers/$callingNumberId endpoint.
     *
     * @param callingNumberId The {@code callingNumberId} of the desired calling number.
     * @param options The {@code CallingNumberUpdateOptions} to change in the target calling number.
     *
     * @see com.vailsys.persephony.api.phoneNumber.CallingNumberUpdateOptions
     * @return The calling number matching the {@code callingNumberId} provided.
     */
    public CallingNumber update(String callingNumberId, CallingNumberUpdateOptions options) throws PersyException {
        return CallingNumber.fromJson(this.POST(this.getCallingNumberPath(callingNumberId), gson.toJson(options)));
    }

    /**
     * Retrieve a list of calling numbers associated with the {@code actingAccountId}. This wraps an HTTP GET request to the Persephony API's /Accounts/$accountId/CallingNumbers endpoint. This will retrieve all calling numbers for the acting account.
     *
     * @return An in-language representation of Persephony's paginated list response. This will be a paginated list of calling numbers as returned by the Persephony API.
     */
    public CallingNumberList get() throws PersyException {
        return new CallingNumberList(this.getCredentialAccountId(), this.getCredentialAuthToken(), this.GET(this.getPath()));
    }

    /**
     * Retrieve a list of calling numbers associated with the {@code actingAccountId}. This wraps an HTTP GET request to the Persephony API's /Accounts/$accountId/CallingNumbers endpoint. This will retrieve all calling numbers for the acting account.
     *
     *@param filters an object containing a number of possible ways to filter the calling numbers returned by Persephony
     * @see com.vailsys.persephony.api.phoneNumber.CallingNumberSearchFilters
     *
     * @return An in-language representation of Persephony's paginated list response. This will be a paginated list of calling numbers as returned by the Persephony API.
     */
    public CallingNumberList get(CallingNumberSearchFilters filters) throws PersyException {
        HashMap<String,String> filtersMap;

        try {
            filtersMap = gson.fromJson(gson.toJson(filters), APIAccountRequester.GETMapType);
        } catch (JsonSyntaxException jse) {
            throw new PersyJSONException(jse);
        }
        return new CallingNumberList(this.getCredentialAccountId(), this.getCredentialAuthToken(), this.GET(this.getPath(), filtersMap));
    }
}