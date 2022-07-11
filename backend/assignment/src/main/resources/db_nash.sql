PGDMP     $    9        
        z            db_nash    14.3    14.3 G    D           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            E           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            F           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            G           1262    45345    db_nash    DATABASE     k   CREATE DATABASE db_nash WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE db_nash;
                postgres    false            �            1259    45347    account    TABLE     ~  CREATE TABLE public.account (
    acc_id integer NOT NULL,
    address character varying(255),
    create_date timestamp without time zone,
    email character varying(255),
    password character varying(255),
    phone character varying(255),
    role character varying(255),
    status boolean,
    update_date timestamp without time zone,
    username character varying(255)
);
    DROP TABLE public.account;
       public         heap    postgres    false            �            1259    45346    account_acc_id_seq    SEQUENCE     �   CREATE SEQUENCE public.account_acc_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.account_acc_id_seq;
       public          postgres    false    210            H           0    0    account_acc_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.account_acc_id_seq OWNED BY public.account.acc_id;
          public          postgres    false    209            �            1259    45356    cart    TABLE     �   CREATE TABLE public.cart (
    cart_id integer NOT NULL,
    active boolean,
    create_date timestamp without time zone,
    update_date timestamp without time zone,
    acc_id integer
);
    DROP TABLE public.cart;
       public         heap    postgres    false            �            1259    45355    cart_cart_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cart_cart_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.cart_cart_id_seq;
       public          postgres    false    212            I           0    0    cart_cart_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.cart_cart_id_seq OWNED BY public.cart.cart_id;
          public          postgres    false    211            �            1259    45362 	   cart_item    TABLE     s   CREATE TABLE public.cart_item (
    cart_id integer NOT NULL,
    pro_id integer NOT NULL,
    quantity integer
);
    DROP TABLE public.cart_item;
       public         heap    postgres    false            �            1259    45368    category    TABLE     �   CREATE TABLE public.category (
    cate_id integer NOT NULL,
    create_date timestamp without time zone,
    description text,
    name character varying(255),
    status character varying(255),
    update_date timestamp without time zone
);
    DROP TABLE public.category;
       public         heap    postgres    false            �            1259    45367    category_cate_id_seq    SEQUENCE     �   CREATE SEQUENCE public.category_cate_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.category_cate_id_seq;
       public          postgres    false    215            J           0    0    category_cate_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.category_cate_id_seq OWNED BY public.category.cate_id;
          public          postgres    false    214            �            1259    53144 	   employees    TABLE     �   CREATE TABLE public.employees (
    id bigint NOT NULL,
    email character varying(255) NOT NULL,
    first_name character varying(255) NOT NULL,
    last_name character varying(255) NOT NULL
);
    DROP TABLE public.employees;
       public         heap    postgres    false            �            1259    53143    employees_id_seq    SEQUENCE     y   CREATE SEQUENCE public.employees_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.employees_id_seq;
       public          postgres    false    225            K           0    0    employees_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.employees_id_seq OWNED BY public.employees.id;
          public          postgres    false    224            �            1259    45377    ordered    TABLE     �   CREATE TABLE public.ordered (
    order_id integer NOT NULL,
    cart_id integer,
    create_date timestamp without time zone,
    status character varying(255),
    update_date timestamp without time zone,
    acc_id integer
);
    DROP TABLE public.ordered;
       public         heap    postgres    false            �            1259    45376    ordered_order_id_seq    SEQUENCE     �   CREATE SEQUENCE public.ordered_order_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.ordered_order_id_seq;
       public          postgres    false    217            L           0    0    ordered_order_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.ordered_order_id_seq OWNED BY public.ordered.order_id;
          public          postgres    false    216            �            1259    45384    product    TABLE     B  CREATE TABLE public.product (
    pro_id integer NOT NULL,
    amount integer,
    create_date timestamp without time zone,
    description character varying(5000),
    product_name character varying(255),
    price double precision,
    status boolean,
    update_date timestamp without time zone,
    cate_id integer
);
    DROP TABLE public.product;
       public         heap    postgres    false            �            1259    45393    product_image    TABLE     w   CREATE TABLE public.product_image (
    id integer NOT NULL,
    img_url character varying(255),
    pro_id integer
);
 !   DROP TABLE public.product_image;
       public         heap    postgres    false            �            1259    45392    product_image_id_seq    SEQUENCE     �   CREATE SEQUENCE public.product_image_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.product_image_id_seq;
       public          postgres    false    221            M           0    0    product_image_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.product_image_id_seq OWNED BY public.product_image.id;
          public          postgres    false    220            �            1259    45383    product_pro_id_seq    SEQUENCE     �   CREATE SEQUENCE public.product_pro_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.product_pro_id_seq;
       public          postgres    false    219            N           0    0    product_pro_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.product_pro_id_seq OWNED BY public.product.pro_id;
          public          postgres    false    218            �            1259    45400    product_rate    TABLE       CREATE TABLE public.product_rate (
    id integer NOT NULL,
    acc_id integer,
    comment character varying(255),
    create_date timestamp without time zone,
    rate double precision,
    status boolean,
    updated_date timestamp without time zone,
    pro_id integer
);
     DROP TABLE public.product_rate;
       public         heap    postgres    false            �            1259    45399    product_rate_id_seq    SEQUENCE     �   CREATE SEQUENCE public.product_rate_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.product_rate_id_seq;
       public          postgres    false    223            O           0    0    product_rate_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.product_rate_id_seq OWNED BY public.product_rate.id;
          public          postgres    false    222            �           2604    45350    account acc_id    DEFAULT     p   ALTER TABLE ONLY public.account ALTER COLUMN acc_id SET DEFAULT nextval('public.account_acc_id_seq'::regclass);
 =   ALTER TABLE public.account ALTER COLUMN acc_id DROP DEFAULT;
       public          postgres    false    210    209    210            �           2604    45359    cart cart_id    DEFAULT     l   ALTER TABLE ONLY public.cart ALTER COLUMN cart_id SET DEFAULT nextval('public.cart_cart_id_seq'::regclass);
 ;   ALTER TABLE public.cart ALTER COLUMN cart_id DROP DEFAULT;
       public          postgres    false    212    211    212            �           2604    45371    category cate_id    DEFAULT     t   ALTER TABLE ONLY public.category ALTER COLUMN cate_id SET DEFAULT nextval('public.category_cate_id_seq'::regclass);
 ?   ALTER TABLE public.category ALTER COLUMN cate_id DROP DEFAULT;
       public          postgres    false    214    215    215            �           2604    53147    employees id    DEFAULT     l   ALTER TABLE ONLY public.employees ALTER COLUMN id SET DEFAULT nextval('public.employees_id_seq'::regclass);
 ;   ALTER TABLE public.employees ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    225    224    225            �           2604    45380    ordered order_id    DEFAULT     t   ALTER TABLE ONLY public.ordered ALTER COLUMN order_id SET DEFAULT nextval('public.ordered_order_id_seq'::regclass);
 ?   ALTER TABLE public.ordered ALTER COLUMN order_id DROP DEFAULT;
       public          postgres    false    216    217    217            �           2604    45387    product pro_id    DEFAULT     p   ALTER TABLE ONLY public.product ALTER COLUMN pro_id SET DEFAULT nextval('public.product_pro_id_seq'::regclass);
 =   ALTER TABLE public.product ALTER COLUMN pro_id DROP DEFAULT;
       public          postgres    false    218    219    219            �           2604    45396    product_image id    DEFAULT     t   ALTER TABLE ONLY public.product_image ALTER COLUMN id SET DEFAULT nextval('public.product_image_id_seq'::regclass);
 ?   ALTER TABLE public.product_image ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    221    220    221            �           2604    45403    product_rate id    DEFAULT     r   ALTER TABLE ONLY public.product_rate ALTER COLUMN id SET DEFAULT nextval('public.product_rate_id_seq'::regclass);
 >   ALTER TABLE public.product_rate ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    222    223    223            2          0    45347    account 
   TABLE DATA           |   COPY public.account (acc_id, address, create_date, email, password, phone, role, status, update_date, username) FROM stdin;
    public          postgres    false    210   ,S       4          0    45356    cart 
   TABLE DATA           Q   COPY public.cart (cart_id, active, create_date, update_date, acc_id) FROM stdin;
    public          postgres    false    212   �S       5          0    45362 	   cart_item 
   TABLE DATA           >   COPY public.cart_item (cart_id, pro_id, quantity) FROM stdin;
    public          postgres    false    213   �S       7          0    45368    category 
   TABLE DATA           `   COPY public.category (cate_id, create_date, description, name, status, update_date) FROM stdin;
    public          postgres    false    215   T       A          0    53144 	   employees 
   TABLE DATA           E   COPY public.employees (id, email, first_name, last_name) FROM stdin;
    public          postgres    false    225   �T       9          0    45377    ordered 
   TABLE DATA           ^   COPY public.ordered (order_id, cart_id, create_date, status, update_date, acc_id) FROM stdin;
    public          postgres    false    217   �T       ;          0    45384    product 
   TABLE DATA           ~   COPY public.product (pro_id, amount, create_date, description, product_name, price, status, update_date, cate_id) FROM stdin;
    public          postgres    false    219   �T       =          0    45393    product_image 
   TABLE DATA           <   COPY public.product_image (id, img_url, pro_id) FROM stdin;
    public          postgres    false    221   Pa       ?          0    45400    product_rate 
   TABLE DATA           l   COPY public.product_rate (id, acc_id, comment, create_date, rate, status, updated_date, pro_id) FROM stdin;
    public          postgres    false    223   Od       P           0    0    account_acc_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.account_acc_id_seq', 1, true);
          public          postgres    false    209            Q           0    0    cart_cart_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.cart_cart_id_seq', 1, false);
          public          postgres    false    211            R           0    0    category_cate_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.category_cate_id_seq', 3, true);
          public          postgres    false    214            S           0    0    employees_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.employees_id_seq', 1, false);
          public          postgres    false    224            T           0    0    ordered_order_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.ordered_order_id_seq', 1, false);
          public          postgres    false    216            U           0    0    product_image_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.product_image_id_seq', 20, true);
          public          postgres    false    220            V           0    0    product_pro_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.product_pro_id_seq', 20, true);
          public          postgres    false    218            W           0    0    product_rate_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.product_rate_id_seq', 1, false);
          public          postgres    false    222            �           2606    45354    account account_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (acc_id);
 >   ALTER TABLE ONLY public.account DROP CONSTRAINT account_pkey;
       public            postgres    false    210            �           2606    45366    cart_item cart_item_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.cart_item
    ADD CONSTRAINT cart_item_pkey PRIMARY KEY (cart_id, pro_id);
 B   ALTER TABLE ONLY public.cart_item DROP CONSTRAINT cart_item_pkey;
       public            postgres    false    213    213            �           2606    45361    cart cart_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.cart
    ADD CONSTRAINT cart_pkey PRIMARY KEY (cart_id);
 8   ALTER TABLE ONLY public.cart DROP CONSTRAINT cart_pkey;
       public            postgres    false    212            �           2606    45375    category category_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (cate_id);
 @   ALTER TABLE ONLY public.category DROP CONSTRAINT category_pkey;
       public            postgres    false    215            �           2606    53151    employees employees_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.employees DROP CONSTRAINT employees_pkey;
       public            postgres    false    225            �           2606    45382    ordered ordered_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.ordered
    ADD CONSTRAINT ordered_pkey PRIMARY KEY (order_id);
 >   ALTER TABLE ONLY public.ordered DROP CONSTRAINT ordered_pkey;
       public            postgres    false    217            �           2606    45398     product_image product_image_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.product_image
    ADD CONSTRAINT product_image_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.product_image DROP CONSTRAINT product_image_pkey;
       public            postgres    false    221            �           2606    45391    product product_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (pro_id);
 >   ALTER TABLE ONLY public.product DROP CONSTRAINT product_pkey;
       public            postgres    false    219            �           2606    45405    product_rate product_rate_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.product_rate
    ADD CONSTRAINT product_rate_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.product_rate DROP CONSTRAINT product_rate_pkey;
       public            postgres    false    223            �           2606    45407 #   account ukgex1lmaqpg0ir5g1f5eftyaa1 
   CONSTRAINT     b   ALTER TABLE ONLY public.account
    ADD CONSTRAINT ukgex1lmaqpg0ir5g1f5eftyaa1 UNIQUE (username);
 M   ALTER TABLE ONLY public.account DROP CONSTRAINT ukgex1lmaqpg0ir5g1f5eftyaa1;
       public            postgres    false    210            �           2606    45413 %   cart_item fk1uobyhgl1wvgt1jpccia8xxs3    FK CONSTRAINT     �   ALTER TABLE ONLY public.cart_item
    ADD CONSTRAINT fk1uobyhgl1wvgt1jpccia8xxs3 FOREIGN KEY (cart_id) REFERENCES public.cart(cart_id);
 O   ALTER TABLE ONLY public.cart_item DROP CONSTRAINT fk1uobyhgl1wvgt1jpccia8xxs3;
       public          postgres    false    212    213    3216            �           2606    45418 %   cart_item fk3bd3w8r027xksw3hfxyhu09dv    FK CONSTRAINT     �   ALTER TABLE ONLY public.cart_item
    ADD CONSTRAINT fk3bd3w8r027xksw3hfxyhu09dv FOREIGN KEY (pro_id) REFERENCES public.product(pro_id);
 O   ALTER TABLE ONLY public.cart_item DROP CONSTRAINT fk3bd3w8r027xksw3hfxyhu09dv;
       public          postgres    false    213    3224    219            �           2606    45433 )   product_image fk5mhfpl6mm0oljybv7k1yha83e    FK CONSTRAINT     �   ALTER TABLE ONLY public.product_image
    ADD CONSTRAINT fk5mhfpl6mm0oljybv7k1yha83e FOREIGN KEY (pro_id) REFERENCES public.product(pro_id);
 S   ALTER TABLE ONLY public.product_image DROP CONSTRAINT fk5mhfpl6mm0oljybv7k1yha83e;
       public          postgres    false    3224    219    221            �           2606    45408     cart fkexcdd1pex25twxkpsltwk2y7w    FK CONSTRAINT     �   ALTER TABLE ONLY public.cart
    ADD CONSTRAINT fkexcdd1pex25twxkpsltwk2y7w FOREIGN KEY (acc_id) REFERENCES public.account(acc_id);
 J   ALTER TABLE ONLY public.cart DROP CONSTRAINT fkexcdd1pex25twxkpsltwk2y7w;
       public          postgres    false    210    3212    212            �           2606    45428 "   product fkll9b6w9lwjkhiymqatom6jbd    FK CONSTRAINT     �   ALTER TABLE ONLY public.product
    ADD CONSTRAINT fkll9b6w9lwjkhiymqatom6jbd FOREIGN KEY (cate_id) REFERENCES public.category(cate_id);
 L   ALTER TABLE ONLY public.product DROP CONSTRAINT fkll9b6w9lwjkhiymqatom6jbd;
       public          postgres    false    219    3220    215            �           2606    45423 #   ordered fkp640qrr68ytq56r94t3uvnjkq    FK CONSTRAINT     �   ALTER TABLE ONLY public.ordered
    ADD CONSTRAINT fkp640qrr68ytq56r94t3uvnjkq FOREIGN KEY (acc_id) REFERENCES public.account(acc_id);
 M   ALTER TABLE ONLY public.ordered DROP CONSTRAINT fkp640qrr68ytq56r94t3uvnjkq;
       public          postgres    false    210    217    3212            �           2606    45438 (   product_rate fks86au96r4f5fxfaf833b8nk8d    FK CONSTRAINT     �   ALTER TABLE ONLY public.product_rate
    ADD CONSTRAINT fks86au96r4f5fxfaf833b8nk8d FOREIGN KEY (pro_id) REFERENCES public.product(pro_id);
 R   ALTER TABLE ONLY public.product_rate DROP CONSTRAINT fks86au96r4f5fxfaf833b8nk8d;
       public          postgres    false    3224    223    219            2   �   x�3��K,��4202�50�54P04�22�24�375�LtH�M���K���T1JT14Pq�K-s�0+�O2�L	���,�3�(�42�-4��M6w,���+�
���,K�40426153���tt����,�mgJnfW� �(�      4      x������ � �      5      x������ � �      7   �   x�3�4202�50�54P00�24�22ҳ06�L>�0Y����y
w��U�9� $�09C!%Q!���%�>AN��̲T\&rc���[`���(1/]���̇��s9CPx����e�"c`ejne`�ghh�Ś�c�^4;%����i������������9W� ?<g�      A      x������ � �      9      x������ � �      ;   G  x��ZKo�V^S��nR$ Ê/�v��8n��Hr�fC���t%*�w1�bPdQŠ(��RO�N��M�Ad����'4�d�9��"%:�E�"� �d�������Jj�(iEM�Z,_U��X���^Q��&�]/���8d�M�G�����+�X;8?qX�(��3ǅK�����؛�x�)�{��}�o���|���󓀩l���Ȇo��W~��p�	۷eF/Ώ=���)s� ��qa�8ǉ�l��}��.l�y򛇰����q�������6���p�)ҵF��n�;-�h�6{۝��eͨJ� �mD�?ZU1Kҭ�����iy6�@�]�=�Y�ԔR�T�������n⏲y�
,���W��rq2w��a�h��q4ѫ��p�ĸ��=�Ӫ�w}�����f�ĳC�	��pB��8�$�x�9����,�ۗ��źX���llO�9��,6w����N��F��]0�H�?�q��'~���0��ׯ<R�w��n��'��r�xJ��<\�}�`���3x���z��GG�	Ȼ=�]����O�;��%yr���ZȇK�#��:�9z�l�.mu�6���,�o�/|f����z�N��v{�ջ�%�fU�Tּ&�jA�s�JS��א�k�O܁���a8�-\�|fT\��fE�_zl�h��.%�d7B����!�p�y�����!������~��e=��+^1�ZyS�D3�`�in�T �jJ�����î�Z���F�ѻ�.��ٔ}f�.*��"�foy�76����
��#$ŏi�x�5���c�|��Y�$!(p�� � �)s��e��S���2��,>0U���?QS-��a0�J�l���l���݆@I��!�b#�I�	&]�v�=BD3�`�<{"��^0����!�Z�}�|��hyv<£眴����ؒ�\�D*�d�z)*�Z(�Ae�]��G]�~Az`(���h�:$��k� ���E�$:��!x���a@���R?��V�s��nm������6���E]ݔ<�L-T�$/�t]��e��v�ڱ���ή[�[����^���z=K�<NU�z)7;.r�҉�>�e*�w1]$A���#χc;��q��� nĨ��gm�v<��Ȩ��?���g�H܁<����K}�/߆��&��3�{H��?��� �̓QH1���`h��/�[�u7���2:h���9|�G�7��N}���@�H����������U����?C���	d�!�4�,�!��d|��h���s�ٱ`�"�1�өi�;�v�	"8��)Oפ���|#4���BƐ�aF����_�ZjS����@9��kr�r���d�J\e٘�EH6D0��г��m�����dA����HdiX~�N�����SLy��ß���ՄO}	�^46�0F-T�U��b����-�$�!a�͖��*����N���ձMՒp5S6y=�u��2<[*g��Ĩ	�Q������l�j4EJ�jNM���by*5��ժ�F��Z��K�!�_K8*!���9�w�9���nZ^�ߝ��������Y��
3��( ���oj('�߅!����v�+%�,i�DMxDU�Z��%�bj��P׆�f@N������X+�&�t<`�0��н
dKVl��K�2�4G�\Fl��_�Ae�vNs	0w�fh��/@�����F�㞼x�lD��گn�?cl|�^�ܸ��3%X����<��%�]ܦʙ�e8������	�L��z��l3�"i�?Xu1V��Ӣ��1�W`Dn�I3���o�91�Z0�̬״��������i]�n[��N;��B�[#��$�jj��s����&�#��5U��2��ɐ�W�R�E���1�No�u<��0���%f� �l]��1e�_�p{щ/��=�x" !�pK�]N1 -������U:e/��VA)=�H��!��H%���+�"�ŉM�ct�c<�k����T�� ܓ#!�FC��͆��!	Ȫ��j՜)Xb/���y���h�*� ^�\�-|��yQ+�������q�[���#6C=\䭶�6��k�;�/٢竤�@Ds�?N�!��D�ɖ:`j`n,�h�/{�#Z����7 ����i����hZ,蹚h���uv���:2�H7�r�ce0��i�1����B�lek�c��z e�� b�(,Ȣz����7ai8�(�WA;/q�QX?�0!���A,�'�u�ÔL��.�i�'D�'pE.��_�zs�%��;a���,@��L���i0��舼����x1�MTc�8��:�*+���N�im�P(�b�������CN�Y[5�Rq�ڱ9��y�Y�\S���U��m�uc��[& �	�0��lcAB) ������O��Gg�z�h�Q�� ��(83�f:�Q�î��J�q�����;d�TίF�+����,mR�����6`��v>�9�v�ֺU�b����)�:�%o\�Vj��T*e1�T[�,_φ��7�9����0ȯ�Ui����g-I���<����=�Oz(=���8��䕐�(uD�B�?>"�����wW�Y?1��bi�����O�f�j�fV���RiSz^O��%o����zY�Q��)���<.~n���?�3=���2M��R��θ�'�#&��S�Ykh�JZN�L����Z�8�(I�l�zi��̃".���>�/"��&�/1��@H%�ڶ��0�2�(ŦK���mn�x��'��N�W^&�ې�6:�^�F��4M�9Ij���L�W��y#`~4E+�R?U��V`���?G]��x�ǿu,� �&�q~1yd���D��EܵV:�y		�:^ÑeOÌ�p�YȻ��n��g[V�:���n�����a�F�AB�L����BD+hy�?M�UE���5���ϩ/�溫��Q���݀�Epr9>W�����B�||�a�#6M�~£���Wba@n!��Y�A�9���%�^��L$HT�=e�d��t+M7���r�>n�4J.
�?�N�j�ʪ��m�m������aꥒ��|�^��R(�j�˹      =   �  x����n�F��3��d8���3d�nd�����tQ��҅��y�'x�ض�������y^����n���I���oT_
�~�M���z<�z���&mr�)V.��L�Y4���M.��G}�W����'tL��4F��4k}i��k��Z?�:_7{I׋��ST�:TR���C�3���Z�5�K;��>�_�Y����lRKd�jM!�S��[믯�����Z�<~M���̾��>�X�ҘU$�H�A-��n���������r>�۷�zS�!4�0f
%cRH!��!7N�^�������<���x�|����Qqx�Qkj5�Y'$��������l�w�G�Y#Ę�4���٧T��{s���p'���2k�ڴ4�Z+��Z�����C��x^����K�T��Q�Z>MVB�qH�%�D��v���n���*߁jh��d$T��r�<xz�vt~9��B���)tZ-ᇟt����%�۰�5�V�x6�)!��!:�Q��:�L˷�\p��r��V���+a�����6��@�z�����JJ:j���[��:?z��Ԙ��ۙ3r2I,�Ө�=
4ŇR����<
�A-����dz&�6�ǠV; SR"��6 RT<�����;1z���Y��j�Ɲ\&�oΓ"&��b�nv�Ǯ���W7��lK$�>2ܥP�>��+l(��N��х�����D�����H�����1��S����9�/�t�m      ?      x������ � �     