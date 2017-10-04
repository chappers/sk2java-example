class Brain {

    public static int predict(float[] atts) {
        if (atts.length != 20) { return -1; }
    
        double[][] coefs = {{20.593458459048051, 46.208859491258387, 92.045064588784982, -11.383840415263183, 37.357702616582863, 14.351492291806464, 10.910157116322377, 0.2025367652833184, -15.991392961555748, -25.715054222130895, 80.192694633588914, -19.424674273407369, -3.0409198459548072, 11.336663827034686, -5.7907358530605038, 49.294332580893929, 29.018320972389233, -2.700931563014048, -0.76680248858631384, 8.4582585784579862}, {0.35329456785547758, -19.616379572064975, -46.945042683041329, -30.379168621058238, -0.97976740244606997, -19.738632585388238, 14.737229211860411, 39.939811323128659, 16.542352945192526, 1.4659659348958323, -91.150173505159614, 1.6674712864195467, 28.403247832385869, -25.377623389677836, -20.870209543847235, -4.2895912423198785, 5.6663344202386963, -7.322301640243837, -39.515506899612724, -10.92915365722304}, {10.297294092895324, 10.849830949633791, -14.814968711437441, 34.291247355453606, -36.742936782828266, -5.7855650321688952, 12.447694016338254, -43.479417234995218, 1.0850200199520972, 20.882132594112424, 41.614130120083601, -20.856339112827662, -19.291610227725204, -41.581698386930441, -37.363524512297644, -30.558124194999355, -15.469761833643396, 2.0059861182655139, 3.7167127737103747, -10.143994433128444}};
        double[] inters = {-44.461491563531901, -77.704301116950177, -96.549858233627319};
    
        int class_idx = -1;
        double class_val = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < 3; i++) {
            double prob = 0.;
            for (int j = 0; j < 20; j++) {
                prob += coefs[i][j] * atts[j];
            }
            if (prob + inters[i] > class_val) {
                class_val = prob + inters[i];
                class_idx = i;
            }
        }
        return class_idx;
    }

    public static void main(String[] args) {
        if (args.length == 20) {
            float[] atts = new float[args.length];
            for (int i = 0, l = args.length; i < l; i++) {
                atts[i] = Float.parseFloat(args[i]);
            }
            System.out.println(Brain.predict(atts));
        }
    }
}