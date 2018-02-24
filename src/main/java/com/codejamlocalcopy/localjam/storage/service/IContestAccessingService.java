package com.codejamlocalcopy.localjam.storage.service;

import com.codejamlocalcopy.localjam.storage.pojo.ContestRoot;

import java.io.IOException;

/**
 * Service of contest pojo accessing (read/write) methods.
 */
public interface IContestAccessingService {

    /**
     * Read ContestRoot - the pojo object of contests main board - from storage file.
     *
     * @return ContestRoot
     * @throws IOException IOException
     */
    ContestRoot readContestRoot() throws IOException;

    /**
     * Write ContestRoot - the pojo object of contests main board - into storage file.
     *
     * @param json - json string
     * @throws IOException IOException
     */
    void writeContestRoot(String json) throws IOException;
}
