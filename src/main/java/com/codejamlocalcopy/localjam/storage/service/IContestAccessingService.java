package com.codejamlocalcopy.localjam.storage.service;

import com.codejamlocalcopy.localjam.storage.pojo.ContestRoot;
import com.codejamlocalcopy.localjam.storage.exception.LocalJamStorageRuntimeException;

import java.io.IOException;

/**
 * Service of contest pojo accessing (read/write) methods.
 */
public interface IContestAccessingService {

    /**
     * Read ContestRoot - the pojo object of contests main board - from storage file.
     *
     * @return ContestRoot or null if not existing in local storage.
     */
    ContestRoot readContestRoot();

    /**
     * Write ContestRoot - the pojo object of contests main board - into storage file.
     *
     * @param json - json string
     * @throws LocalJamStorageRuntimeException when fail to do Files operations.
     */
    void writeContestRoot(String json);
}
