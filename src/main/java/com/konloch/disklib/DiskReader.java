package com.konloch.disklib;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;

/**
 * Small disk reading util
 *
 * @author Konloch
 * @since Oct 18, 2014
 */
public class DiskReader
{
	/**
	 * Used to load from file
	 */
	public static ArrayList<String> read(String file) throws IOException
	{
		return read(new File(file));
	}

	/**
	 * Used to load from file
	 */
	public static ArrayList<String> read(File file) throws IOException
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
	public static String[] readLines(String file) throws IOException
	{
		return read(file).toArray(new String[0]);
	}
	
	
	/**
	 * Returns a byte[] from the file
	 */
	public static byte[] readBytes(String file) throws IOException
	{
		return readBytes(new File(file));
	}

	/**
	 * Returns a byte[] from the file
	 */
	public static byte[] readBytes(File file) throws IOException
	{
		return Files.readAllBytes(file.toPath());
	}
	
	/**
	 * Used to alert the user this is a library
	 */
	public static void main(String[] args)
	{
		throw new RuntimeException("Incorrect usage");
	}
}