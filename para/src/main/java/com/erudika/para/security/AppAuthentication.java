/*
 * Copyright 2013-2014 Erudika. http://erudika.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * For issues and patches go to: https://github.com/erudika
 */
package com.erudika.para.security;

import com.erudika.para.core.App;
import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * A simple wrapper for the authentication object
 * @author Alex Bogdanovski [alex@erudika.com]
 */
public class AppAuthentication implements Authentication {
	private static final long serialVersionUID = 1L;

	private final App principal;
	private final Object details;
	private boolean authenticated;

	/**
	 * Default constructor
	 * @param principal the application object
	 */
	public AppAuthentication(App principal) {
		this.principal = principal;
		this.details = principal;
		this.authenticated = true;
	}

	/**
	 * A list of roles for the authenticated application
	 * @return a list of roles
	 */
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(App.APP_ROLE));
	}

	/**
	 * Null
	 * @return credentials string
	 */
	public Object getCredentials() {
		return null;
	}

	/**
	 * The application object
	 * @return the application
	 */
	public Object getDetails() {
		return details;
	}

	/**
	 * The application object
	 * @return the application
	 */
	public Object getPrincipal() {
		return principal;
	}

	/**
	 * Checks if the application is authenticated
	 * @return true if authenticated
	 */
	public boolean isAuthenticated() {
		return authenticated;
	}

	/**
	 * Sets the authentication status
	 * @param isAuthenticated true if authenticated
	 */
	public void setAuthenticated(boolean isAuthenticated) {
		throw new UnsupportedOperationException();
	}

	/**
	 * The application identifier
	 * @return the identifier
	 */
	public String getName() {
		return principal.getAppid();
	}
}
