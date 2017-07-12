package com.vailsys.persephony.api.account;

import com.vailsys.persephony.api.APIRequester;
import com.vailsys.persephony.api.PersyException;

import static com.vailsys.persephony.json.PersyGson.gson;

/**
 * This class represents the set of wrappers around the Persephony Accounts API.
 *It provides methods to handle all the operations supported by the Persephony Accounts API.
 */
public class AccountRequester extends APIRequester {
    private static final String pathHead = "Accounts";

    /** The default path for the Accounts endpoint. */
    private final String path;
    /** The accountId for the acting account. */
    private final String actingAccountId;

    /**
     * Creates an AccountRequester. For most SDK users AccountRequesters will be created automatically by the {@link com.vailsys.persephony.api.PersyClient} but is available for more advanced users who only require the features in this specific requester and not the rest of the features of the {@link com.vailsys.persephony.api.PersyClient}.
     *
     * @param credAccountId The accountId to use as authentication credentials in the HTTP Basic Auth header for requests made by this requester.
     * @param credAuthToken The authToken to use as authentication credentials in the HTTP Basic Auth header for requests made by this requester.
     * @param actingAccountId The accountId to as as. This can be the same as {@code credAccountId} or the accountId of a subaccount of the {@code credAccountId}.
     */
    public AccountRequester(String credAccountId, String credAuthToken, String actingAccountId) throws PersyException {
        super(credAccountId, credAuthToken);
        this.actingAccountId = actingAccountId;
        this.path = APIRequester.constructAbsolutePath(pathHead);
    }

    /**
     * Retrieve the {@code path} value generated by the AccountRequester.
     * This is the URL path used in requests to Persephony.
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

    /**
     * Allows SDK developers to change which instance of the Persephony API that the AccountRequester points to.
     *
     * @param newUrl The new URL to use in place of the default APIRequester.PERSY_URL
     */
    protected void setPersyUrl(String newUrl){ super.setPersyUrl(newUrl);}

    private String getAccountPath(String accountId){ return APIRequester.constructPath(this.getPath(), accountId);}

    /**
     * Retrieve a single account from Persephony.
     * @param accountId The {@code accountId} of the desired account.
     *
     * @return The account matching the {@code accountId} provided.
     */
    public Account get(String accountId) throws PersyException {
        return Account.fromJson(this.GET(this.getAccountPath(accountId)));
    }

    /**
     * Update the existing account associated with {@code accountId}.
     * This wraps an HTTP POST request to the Persephony API's /Accounts/$accountId endpoint.
     * @param accountId The {@code accountId} of the desired account.
     * @param options The {@code AccountUpdateOptions} to change in the target account.
     * @see com.vailsys.persephony.api.account.AccountUpdateOptions
     *
     * @return The account matching the {@code accountId} provided.
     */
    public Account update(String accountId, AccountUpdateOptions options) throws PersyException {
        return Account.fromJson(this.POST(this.getAccountPath(accountId), gson.toJson(options)));
    }


}