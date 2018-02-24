package com.codejamlocalcopy.localjam.storage.service;

import java.nio.file.Path;

/**
 * Service of file path related methods.
 */
public interface IContestFilePathService {

    /**
     * Get path of data files directory.
     *
     * @return path of data files directory
     */
    Path getContestDataDirPath();

    /**
     * Get path of image files directory.
     *
     * @return path of image files directory
     */
    Path getContestImageDirPath();

    /**
     * Get path of json files directory.
     *
     * @return path of json files directory
     */
    Path getContestJsonDirPath();
}
