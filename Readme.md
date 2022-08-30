# MPC-II

Material-Price-Calculator - The second approach

## Purpose

This example project is building a little window-based calculator with java-swing. The purpose is to assist a printing-company to calculate their daily-changing material prices easily regarding the needed amount:

## Wanted

- varying prices for some different (supported) materials

- varying width/height measures

- option, to configure the used prices for each material

- maybe the possibility to add new types of material

Calculation is as easy as `width * height * price`.

Prices could basically be hold in a simple file, however later there maybe could come some database support.

## Not wanted

- Any counting / calculation how *much* of any material there actually is in stock

- how much is bought or sold

- any calculation or tracking of earnings / losses

## How to run

If cloned the repo, you can (on Win11) run the following in the main project directory:

```
./run.bat
```

or otherwise run the commands on your own:

```
javac -d bin @classes
java -cp bin Main
```

## How to use

- Please make sure to hit the enter key after every change made to any textfields to make the changes take effect in the program.

- Only supports ascii-characters (not utf8).

## Platforms developed on

- Windows 11

- openjdk version 18.0.2
