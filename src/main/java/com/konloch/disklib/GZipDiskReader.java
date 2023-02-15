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
	 * Decompresses and loads a gzip file into a String Array from a valid String path
	 *
	 * @param file any valid file path to open
	 * @return String Array with the file content lines
	 * @throws IOException if an I/O error occurs reading from the stream
	 * @throws DataFormatException
	 */
	public static String[] readLines(String file) throws IOException, DataFormatException
	{
		return read(file).toArray(new String[0]);
	}
	
	/**
	 * Decompresses and load a file into a String Array from a File object
	 *
	 * @param file the file object to open
	 * @return String Array with the file content lines
	 * @throws IOException if an I/O error occurs reading from the stream
	 * @throws DataFormatException
	 */
	public static String[] readLines(File file) throws IOException, DataFormatException
	{
		return read(file).toArray(new String[0]);
	}
	
	/**
	 * Loads a file into a byte Array from a valid String path
	 *
	 * @param file any valid file path to open
	 * @return byte Array with the file content lines
	 * @throws IOException if an I/O error occurs reading from the stream
	 * @throws DataFormatException
	 */
	public static byte[] readBytes(String file) throws IOException, DataFormatException
	{
		return readBytes(new File(file));
	}
	
	/**
	 * Decompresses and loads a file into a byte Array from a File object
	 *
	 * @param file the file object to open
	 * @return byte Array with the file content lines
	 * @throws IOException if an I/O error occurs reading from the stream
	 * @throws DataFormatException
	 */
	public static byte[] readBytes(File file) throws IOException, DataFormatException
	{
		return GZip.decompress(Files.readAllBytes(file.toPath()));
	}
	
	/**
	 * Used to decompress and load a gzip file into a String ArrayList from a valid String path
	 *
	 * @param file any valid file path to open
	 * @return String ArrayList with the file content lines
	 * @throws IOException if an I/O error occurs reading from the stream
	 * @throws DataFormatException
	 */
	public static ArrayList<String> read(String file) throws IOException, DataFormatException
	{
		return read(new File(file));
	}
	
	/**
	 * Used to decompress and load a gzip file into a String ArrayList from a File object
	 *
	 * @param file the file object to open
	 * @return String ArrayList with the file content lines
	 * @throws IOException if an I/O error occurs reading from the stream
	 * @throws DataFormatException
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
}