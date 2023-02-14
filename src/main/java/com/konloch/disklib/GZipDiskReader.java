package com.konloch.disklib;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

/**
 * Small disk reading util, with gzip decompression built in
 *
 * @author Konloch
 * @since Oct 18, 2014
 */
public class GZipDiskReader
{
	/**
	 * Used to load from file
	 */
	public static ArrayList<String> read(String file) throws IOException, DataFormatException
	{
		return read(new File(file));
	}

	/**
	 * Used to load from file
	 */
	public static ArrayList<String> read(File file) throws IOException, DataFormatException
	{
		ArrayList<String> array = new ArrayList<>();

		String fullString = new String(readBytes(file), StandardCharsets.UTF_8);

		BufferedReader reader = null;
		try
		{
			reader = new BufferedReader(new StringReader(fullString));
			String add;

			while ((add = reader.readLine()) != null)
			{
				array.add(add);
			}
		}
		catch (IOException e)
		{
			throw e;
		}
		finally
		{
			if (reader != null)
				try
				{
					reader.close();
				} catch (Exception ex) {}
		}

		return array;
	}
	
	/**
	 * Used to load from file
	 */
	public static String[] readLines(String file) throws IOException, DataFormatException
	{
		return read(file).toArray(new String[0]);
	}
	
	/**
	 * Returns a byte[] from the file
	 */
	public static byte[] readBytes(String file) throws IOException, DataFormatException
	{
		return readBytes(new File(file));
	}

	/**
	 * Returns a byte[] from the file
	 */
	public static byte[] readBytes(File file) throws IOException, DataFormatException
	{
		return GZip.decompress(Files.readAllBytes(file.toPath()));
	}
}