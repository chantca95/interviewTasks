/*
Chan Tjun Chuang Alex
alexchan@u.nus.edu
*/

import java.util.*;
import java.io.*;

/**
 *	This programme takes in a path to a given directory and returns all file details (even ones nested in subdirectories)
 *	in increasing order of file size.
 */	

public class FileLister {

	public static void main(String[] args) {

		if (args.length != 1) {
            System.err.println("Usage: FileLister <path>");
            System.exit(-1);
        }
		String filePathString = args[0];
		File mainDirectory = new File(filePathString);
		ArrayList<FileData> fileList = new ArrayList<FileData>();
		populateFileList(mainDirectory, fileList);
		FileSizeComparator fsc = new FileSizeComparator();
		//sort by smallest file size first
		fileList.sort(fsc);
		//print out each fileEntry
		for (FileData fdEntry : fileList) {
			System.out.println(fdEntry);
		}
	}

	private static void populateFileList(File directory, ArrayList<FileData> fileList) {
		for (final File fileEntry : directory.listFiles()) {
        	if (fileEntry.isDirectory()) {
            	//recursively call populateFileList until you reach files and not directories.
				populateFileList(fileEntry, fileList);
        	} else {
        		String pathName = fileEntry.getPath();
        		String fileName = fileEntry.getName();
        		long fileSize = fileEntry.length();
            	fileList.add(new FileData(pathName, fileName, fileSize));
            }
        }
	}
}

class FileSizeComparator implements Comparator<FileData> {
	public int compare(FileData fd1, FileData fd2) {
		if(fd1.getSize() > fd2.getSize()) {
			return 1;
		} else {
			return -1;
		}
	}
}

class FileData {
	private String path;
	private String fileName;
	private long size;

	public String getPath() {
		return this.path;
	}

	public String getFileName() {
		return this.fileName;
	}

	public long getSize() {
		return this.size;
	}

	public FileData(String path, String fileName, long size) {
		this.path = path;
		this.fileName = fileName;
		this.size = size;
	}

	@Override
	public String toString() {
		return ("Path: " + path + " || File Name: " + fileName + " || File Size: " + size);
	}
}
