package kr.co.photograph.jhgallery.service;

import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuth1Token;
import kr.co.photograph.jhgallery.component.Flickr;
import lombok.Getter;
import org.scribe.model.Verifier;
import org.springframework.stereotype.Service;

@Service
@Getter
public class FlickrAuthServiceImpl implements FlickrAuthService {

    private final Flickr flickr;
    private final AuthInterface authInterface;
    private final OAuth1RequestToken requestToken;
    private String authUrl;
    private Auth auth;

    public FlickrAuthServiceImpl(Flickr flickr) {
        authInterface = new AuthInterface(flickr.getApikey(), flickr.getSecret(), new REST());
        requestToken = authInterface.getRequestToken();
        authUrl = authInterface.getAuthorizationUrl(this.requestToken, Permission.DELETE);
        this.flickr = flickr;
    }

    @Override
    public void authorize(String tokenKey) throws FlickrException {
        OAuth1Token accessToken = authInterface.getAccessToken(requestToken, new Verifier(tokenKey).getValue());
        auth = authInterface.checkToken(accessToken);
        RequestContext.getRequestContext().setAuth(auth);
    }
}
