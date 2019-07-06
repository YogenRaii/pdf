package com.bitMiners.pdf.repositories;

import com.bitMiners.pdf.domain.Authority;
import com.bitMiners.pdf.domain.types.AuthorityType;

public interface AuthorityRepository {
    Authority findByName(AuthorityType type);
}
