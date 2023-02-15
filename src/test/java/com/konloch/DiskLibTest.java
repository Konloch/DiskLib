package com.konloch;

import com.konloch.disklib.DiskWriter;
import com.konloch.disklib.GZipDiskWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Used to test the API
 *
 * @author Konloch
 * @since 2/14/2023
 */
public class DiskLibTest
{
	public static void main(String[] args) throws Exception
	{
		String path = "testFile";
		
		DiskWriter.append(path);
		DiskWriter.append(path, true);
		DiskWriter.append(path, "line");
		DiskWriter.append(path, "line", true);
		
		ArrayList<String> list = new ArrayList<>(Arrays.asList(new String[]{"line 1", "line 2", "line 3"}));
		DiskWriter.append(path, list);
		
		HashSet<String> set = new HashSet<>(Arrays.asList(new String[]{"line 1", "line 2", "line 3"}));
		DiskWriter.append(path, set);
		
		DiskWriter.write(path);
		DiskWriter.write(path, true);
		DiskWriter.write(path, "line");
		DiskWriter.write(path, "line", true);
		
		list = new ArrayList<>(Arrays.asList(new String[]{"line 1", "line 2", "line 3"}));
		DiskWriter.write(path, list);
		
		set = new HashSet<>(Arrays.asList(new String[]{"line 1", "line 2", "line 3"}));
		DiskWriter.write(path, set);
		
		new File(path).delete();
		path = "gzipTestFile";
		
		GZipDiskWriter.append(path);
		GZipDiskWriter.append(path, true);
		GZipDiskWriter.append(path, "line");
		GZipDiskWriter.append(path, "line", true);
		
		list = new ArrayList<>(Arrays.asList(new String[]{"line 1", "line 2", "line 3"}));
		GZipDiskWriter.append(path, list);
		
		set = new HashSet<>(Arrays.asList(new String[]{"line 1", "line 2", "line 3"}));
		GZipDiskWriter.append(path, set);
		
		GZipDiskWriter.write(path);
		GZipDiskWriter.write(path, true);
		GZipDiskWriter.write(path, "line");
		GZipDiskWriter.write(path, "line", true);
		
		list = new ArrayList<>(Arrays.asList(new String[]{"line 1", "line 2", "line 3"}));
		GZipDiskWriter.write(path, list);
		
		set = new HashSet<>(Arrays.asList(new String[]{"line 1", "line 2", "line 3"}));
		GZipDiskWriter.write(path, set);
		
		new File(path).delete();
	}
}
