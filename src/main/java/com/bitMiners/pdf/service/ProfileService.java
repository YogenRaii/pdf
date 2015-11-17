package com.bitMiners.pdf.service;

import com.bitMiners.pdf.domain.Profile;

public interface ProfileService {
	boolean updateProfile(Profile profile);

	Profile getProfile(int profileId);
}
